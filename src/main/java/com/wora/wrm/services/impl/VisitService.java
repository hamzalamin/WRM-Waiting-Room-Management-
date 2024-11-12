package com.wora.wrm.services.impl;

import com.wora.wrm.mappers.VisitMapper;
import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.repositories.VisitRepository;
import com.wora.wrm.services.interfaces.IVisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService implements IVisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Override
    public VisitDto subscribeVisitor(SubscribeVisitorDto subscribeVisitorDto, Long visitorId, Long waitingRoomId) {
        return null;
    }
}
