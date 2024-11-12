package com.wora.wrm.mappers;


import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.visitDto.*;
import com.wora.wrm.models.entities.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper extends GenericMapper<Visit, VisitDto> {
    VisitDto toDto(Visit visit);
    Visit toEntity(VisitDto dto);
    Visit toEntity(CreateVisitDto dto);
    Visit toEntity(UpdateVisitDto dto);
    Visit toEntity(UpdateVisitorStatusDto dto);
    Visit toEntity(SubscribeVisitorDto dto);
}
