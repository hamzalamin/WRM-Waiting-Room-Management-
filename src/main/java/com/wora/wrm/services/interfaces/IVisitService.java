package com.wora.wrm.services.interfaces;

import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;

public interface IVisitService {
    VisitDto subscribeVisitor(SubscribeVisitorDto subscribeVisitorDto);
}
