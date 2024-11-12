package com.wora.wrm.mappers;


import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.visitDto.*;
import com.wora.wrm.models.entities.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper extends GenericMapper<Visit, VisitDto> {
    Visit toEntity(VisitDto dto);
    Visit toEntity(UpdateVisitorStatusDto dto);
    Visit toEntity(SubscribeVisitorDto dto);
    VisitDto toDto(Visit visit);
}
