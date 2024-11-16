package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.UpdateVisitorStatusDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.models.dtos.visitDto.WaitingTimeDto;
import com.wora.wrm.services.impl.VisitorService;
import com.wora.wrm.services.interfaces.IVisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitController {
    private final IVisitService visitService;
    private final VisitorService visitorService;

    @PostMapping("/save")
    public ResponseEntity<VisitDto> save(@RequestBody @Valid SubscribeVisitorDto subscribeVisitorDto) {
        return new ResponseEntity<>(visitService.subscribeVisitor(subscribeVisitorDto), HttpStatus.CREATED);
    }

    @PutMapping("/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/cancelVisit")
    public ResponseEntity<VisitDto> changeStatus(
            @PathVariable Long visitorId,
            @PathVariable Long waitingRoomId,
            @RequestBody @Valid UpdateVisitorStatusDto updateVisitorStatusDto
    ) {
        return new ResponseEntity<>(visitService.cancelSubscription(updateVisitorStatusDto, visitorId, waitingRoomId), HttpStatus.OK);
    }

    @PutMapping("/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/beginVisit")
    public ResponseEntity<VisitDto> beginVisit(
            @PathVariable Long visitorId,
            @PathVariable Long waitingRoomId,
            @RequestBody @Valid UpdateVisitorStatusDto updateVisitorStatusDto
    ) {
        return new ResponseEntity<>(visitService.beginVisit(updateVisitorStatusDto, visitorId, waitingRoomId), HttpStatus.OK);
    }

    @PutMapping("/visitors/{visitorId}/waiting-rooms/{waitingRoomId}/completeVisit")
    public ResponseEntity<VisitDto> completeVisit(
            @PathVariable Long visitorId,
            @PathVariable Long waitingRoomId,
            @RequestBody @Valid UpdateVisitorStatusDto updateVisitorStatusDto
    ) {
        return new ResponseEntity<>(visitService.completeVisit(updateVisitorStatusDto, visitorId, waitingRoomId), HttpStatus.OK);
    }

    @GetMapping("/visitors/waiting-rooms/List")
    public ResponseEntity<List<VisitDto>> findAll() {
        List<VisitDto> visits = visitService.findAll();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @GetMapping("/findById/visitors/{visitorId}/waiting-rooms/{waitingRoomId}")
    public ResponseEntity<VisitDto> findById(@PathVariable Long visitorId, @PathVariable Long waitingRoomId) {
        return new ResponseEntity<>(visitService.findById(visitorId, waitingRoomId), HttpStatus.OK);
    }

    @GetMapping("/average-waiting-time")
    public ResponseEntity<WaitingTimeDto> calculateAverageWaitingTime() {
        return new ResponseEntity<>(visitService.calculateAverageWaitTime(), HttpStatus.OK);
    }
}
