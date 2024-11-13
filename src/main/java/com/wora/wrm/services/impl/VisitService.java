package com.wora.wrm.services.impl;

import com.wora.wrm.config.VisitProperties;
import com.wora.wrm.mappers.VisitMapper;
import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.entities.Visit;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.models.entities.WaitingRoom;
import com.wora.wrm.models.entities.embeddables.VisitorWaitingRoomId;
import com.wora.wrm.repositories.VisitRepository;
import com.wora.wrm.services.interfaces.IVisitService;
import com.wora.wrm.services.interfaces.IVisitorService;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VisitService implements IVisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final IWaitingRoomService waitingRoomService;
    private final IVisitorService visitorService;
    private final VisitProperties visitProperties;

    @Override
    public VisitDto subscribeVisitor(SubscribeVisitorDto subscribeVisitorDto) {
        WaitingRoom waitingRoom = waitingRoomService.getWaitingRoomEntityById(subscribeVisitorDto.waitingRoomId());
        Visitor visitor = visitorService.getVisitorEntityById(subscribeVisitorDto.visitorId());
        Visit visit = visitMapper.toEntity(subscribeVisitorDto);
        VisitorWaitingRoomId id = new VisitorWaitingRoomId(subscribeVisitorDto.visitorId(), subscribeVisitorDto.waitingRoomId());
        visit.setId(id);
        visit.setVisitor(visitor);
        visit.setWaitingRoom(waitingRoom);
        visit.setArrivalTime(subscribeVisitorDto.arrivalTime());
        visit.setPriority(subscribeVisitorDto.priority());
        visit.setEstimatedProcessingTime(subscribeVisitorDto.estimatedProcessingTime());
        visit.setVisitorStatus(visitProperties.getDefaultVisitorStatus());
        Visit savedVisit = visitRepository.save(visit);
        return visitMapper.toDto(savedVisit);
    }
}
