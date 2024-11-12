package com.wora.wrm.mappers.api;

import javax.swing.text.html.parser.Entity;

public interface GenericMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
