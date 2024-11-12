package com.wora.wrm.services.interfaces;

import com.wora.wrm.models.dtos.visitDto.CreateVisitDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;

public interface IVisitService {
    VisitDto subscribeVisitor(CreateVisitDto createVisitDto);
}
