package com.intercorp.api.retail.service;

import com.intercorp.api.retail.dto.ClienteDto;
import com.intercorp.api.retail.entity.ClienteEntity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ClienteService {
    Map<String,Object> getKpideclientes() throws ExecutionException, InterruptedException;

    ClienteDto save(ClienteDto model);

    String saveClient(ClienteEntity entity) throws InterruptedException, ExecutionException;

    List<ClienteEntity> getClients() throws InterruptedException, ExecutionException;
}
