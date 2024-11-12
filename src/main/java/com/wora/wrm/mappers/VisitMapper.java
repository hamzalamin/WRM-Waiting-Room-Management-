package com.wora.wrm.mappers;


import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.visitDto.CreateVisitDto;
import com.wora.wrm.models.dtos.visitDto.UpdateVisitDto;
import com.wora.wrm.models.dtos.visitDto.UpdateVisitorStatusDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.entities.Visit;

public interface VisitMapper extends GenericMapper<Visit, VisitDto> {
    VisitDto toDto(Visit visit);
    Visit toEntity(VisitDto dto);
    Visit toEntity(CreateVisitDto dto);
    Visit toEntity(UpdateVisitDto dto);
    Visit toEntity(UpdateVisitorStatusDto dto);
}
