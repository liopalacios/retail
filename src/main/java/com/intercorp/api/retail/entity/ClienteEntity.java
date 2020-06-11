package com.intercorp.api.retail.entity;

import com.intercorp.api.retail.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteEntity implements Serializable {

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechanac;

    public static ClienteEntity transformDtoToEntity(ClienteDto model){
        if (model == null) return null;
        return ClienteEntity.builder()
                .nombre(model.getNombre())
                .apellido(model.getApellido())
                .edad(model.getEdad())
                .fechanac(model.getFechanac()).build();
    }

}
