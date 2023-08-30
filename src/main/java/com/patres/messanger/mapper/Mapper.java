package com.patres.messanger.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<ENTITY, DTO> {

    public abstract ENTITY toEntity(DTO dto);

    public List<ENTITY> toEntities(List<DTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
