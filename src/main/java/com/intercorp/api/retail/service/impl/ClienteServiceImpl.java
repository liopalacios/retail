package com.intercorp.api.retail.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.common.collect.ImmutableMap;
import com.google.firebase.cloud.FirestoreClient;
import com.intercorp.api.retail.dto.ClienteDto;
import com.intercorp.api.retail.entity.ClienteEntity;
import com.intercorp.api.retail.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    public static final String COL_NAME="clientes";

    @Override
    public Map<String,Object> getKpideclientes() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<ClienteEntity> entities =null;
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> list = future.get().getDocuments();
        int edades = 0;
        int varianza = 0;
        int media = 0;
        Double desv_standar = 0.00;
        for (DocumentSnapshot snapshot: list) {
            edades += (Long) snapshot.get("edad");
        }
        media = edades/list.size();
        for (DocumentSnapshot snapshot: list) {
            varianza += Math.pow((Long) snapshot.get("edad") - media,2f);
        }
        varianza = varianza / list.size();
        desv_standar = Math.sqrt(varianza);

        return ImmutableMap.of("promedio",media,"desviacion", desv_standar, "total",list.size());
    }

    @Override
    public ClienteDto save(ClienteDto model) {
        ClienteEntity entity = ClienteEntity.transformDtoToEntity(model);
        return model;
    }

    @Override
    public String saveClient(ClienteEntity client) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(client.getDni()).set(client);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<ClienteEntity> getClients() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> list = future.get().getDocuments();
        List<ClienteEntity> entityList = new ArrayList<>();
        for (DocumentSnapshot snapshot: list) {
                entityList.add(snapshot.toObject(ClienteEntity.class));
        }
        return entityList;
    }
}
