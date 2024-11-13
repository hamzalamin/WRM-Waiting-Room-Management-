package com.wora.wrm.mappers;

import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.models.entities.Visitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper extends GenericMapper<Visitor, VisitorDto> {
    VisitorDto toDto(Visitor visitor);
    Visitor toEntity(VisitorDto visitorDto);
}