package com.wora.wrm.services.impl;

import com.wora.wrm.config.VisitProperties;
import com.wora.wrm.exceptions.EntityNotFoundException;
import com.wora.wrm.mappers.VisitMapper;
import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.UpdateVisitorStatusDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.dtos.visitDto.WaitingTimeDto;
import com.wora.wrm.models.entities.Visit;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.models.entities.WaitingRoom;
import com.wora.wrm.models.entities.embeddables.VisitorWaitingRoomId;
import com.wora.wrm.models.enumes.VisitorStatus;
import com.wora.wrm.repositories.VisitRepository;
import com.wora.wrm.services.interfaces.IVisitService;
import com.wora.wrm.services.interfaces.IVisitorService;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

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
        visit.setPriority(visitProperties.getDefaultPriority());
        visit.setEstimatedProcessingTime(visitProperties.getDefaultEstimatedProcessingTime());
        visit.setVisitorStatus(visitProperties.getDefaultVisitorStatus());
        Visit savedVisit = visitRepository.save(visit);
        return visitMapper.toDto(savedVisit);
    }

    @Override
    public VisitDto cancelSubscription(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId) {
        VisitorWaitingRoomId id = new VisitorWaitingRoomId(visitorId, waitingRoomId);
        Visit findVisit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EmbeddedId", id));
        findVisit.setVisitorStatus(updateVisitorStatusDto.visitorStatus());
        Visit updateVisit = visitRepository.save(findVisit);
        return visitMapper.toDto(updateVisit);
    }

    @Override
    public VisitDto beginVisit(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId){
        VisitorWaitingRoomId id = new VisitorWaitingRoomId(visitorId, waitingRoomId);
        Visit findVisit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EmbeddedId", id));
        findVisit.setVisitorStatus(updateVisitorStatusDto.visitorStatus());
        findVisit.setStartTime(updateVisitorStatusDto.startTime());
        Visit updateVisit = visitRepository.save(findVisit);
        return visitMapper.toDto(updateVisit);

    }

    @Override
    public VisitDto completeVisit(UpdateVisitorStatusDto updateVisitorStatusDto, Long visitorId, Long waitingRoomId){
        VisitorWaitingRoomId id = new VisitorWaitingRoomId(visitorId, waitingRoomId);
        Visit findVisit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("EmbeddedId", id));
        findVisit.setVisitorStatus(updateVisitorStatusDto.visitorStatus());
        findVisit.setStartTime(updateVisitorStatusDto.startTime());
        findVisit.setEndTime(updateVisitorStatusDto.endTime());
        Visit updateVisit = visitRepository.save(findVisit);
        return visitMapper.toDto(updateVisit);

    }

    @Override
    public List<VisitDto> findAll(){
        return visitRepository.findAll().stream()
                .map(visitMapper::toDto)
                .toList();
    }

    @Override
    public VisitDto findById(Long visitorId, Long waitingRoomId){
        VisitorWaitingRoomId id = new VisitorWaitingRoomId(visitorId, waitingRoomId);
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visits", id));
        return visitMapper.toDto(visit);
    }

    @Override
    public WaitingTimeDto calculateAverageWaitTime() {
        List<Visit> visits = visitRepository.findAll().stream()
                .filter(visit -> visit.getVisitorStatus() == VisitorStatus.FINISHED)
                .toList();
        System.out.println(visits);

        Duration totalWaitTime = visits.stream()
                .filter(visit -> visit.getArrivalTime() != null && visit.getStartTime() != null)
                .map(visit -> Duration.between(
                        visit.getArrivalTime(),
                        LocalDateTime.of(visit.getArrivalTime().toLocalDate(), visit.getStartTime())
                ))
                .reduce(Duration.ZERO, Duration::plus);

        return new WaitingTimeDto((long) visits.size(), totalWaitTime);
    }

}
