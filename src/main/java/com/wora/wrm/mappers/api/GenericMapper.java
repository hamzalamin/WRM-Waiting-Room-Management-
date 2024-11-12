package com.wora.wrm.mappers.api;

public interface GenericMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
