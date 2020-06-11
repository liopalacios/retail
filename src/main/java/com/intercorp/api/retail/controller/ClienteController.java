package com.intercorp.api.retail.controller;

import com.intercorp.api.retail.dto.ClienteDto;
import com.intercorp.api.retail.entity.ClienteEntity;
import com.intercorp.api.retail.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/kpideclientes")
    public Map<String,Object> kpiClientes() throws ExecutionException, InterruptedException {
        return clienteService.getKpideclientes();
    }

    @GetMapping("/listclientes")
    public ResponseEntity<?> listClientes() throws ExecutionException, InterruptedException {
        List<ClienteEntity> list = clienteService.getClients();
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    @PostMapping("/creacliente")
    public ResponseEntity<?> createClientes(@RequestBody ClienteEntity model) throws ExecutionException, InterruptedException {
        System.out.println(model);
        String resp = clienteService.saveClient(model);
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }
}
