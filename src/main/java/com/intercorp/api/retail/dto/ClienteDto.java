package com.intercorp.api.retail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.intercorp.api.retail.entity.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {
    private String nombre;
    private String apellido;
    private int edad;
    private String fechanac;
    public static ClienteDto transformEntityToDto(ClienteEntity model){
        if (model == null) return null;
        return ClienteDto.builder()
                .nombre(model.getNombre())
                .apellido(model.getApellido())
                .edad(model.getEdad())
                .fechanac(model.getFechanac()).build();
    }
    public static List<ClienteDto> transformEntityToDto(List<ClienteEntity> models){
        if (models == null) return Collections.emptyList();

        return models.stream().map(ClienteDto::transformEntityToDto).collect(Collectors.toList());
    }
}
