package com.wora.wrm.services.impl;

import com.wora.wrm.mappers.VisitMapper;
import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.entities.WaitingRoom;
import com.wora.wrm.repositories.VisitRepository;
import com.wora.wrm.services.interfaces.IVisitService;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService implements IVisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final IWaitingRoomService waitingRoomService;

    @Override
    public VisitDto subscribeVisitor(SubscribeVisitorDto subscribeVisitorDto, Long visitorId, Long waitingRoomId) {
        WaitingRoom waitingRoom = waitingRoomService.getWaitingRoomEntityById(waitingRoomId);
        return null;
    }
}
