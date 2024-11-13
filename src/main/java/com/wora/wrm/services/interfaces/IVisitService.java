package com.wora.wrm.services.interfaces;

import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.UpdateVisitorStatusDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;

import java.util.List;

public interface IVisitService {
    VisitDto subscribeVisitor(SubscribeVisitorDto subscribeVisitorDto);
    VisitDto cancelSubscription(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId);
    VisitDto beginVisit(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId);
    VisitDto completeVisit(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId);
    List<VisitDto> findAll();
    VisitDto findById(Long visitorId, Long waitingRoomId);
}
