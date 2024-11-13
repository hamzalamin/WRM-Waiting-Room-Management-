package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.visitDto.SubscribeVisitorDto;
import com.wora.wrm.models.dtos.visitDto.VisitDto;
import com.wora.wrm.services.interfaces.IVisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitController {
    private final IVisitService visitService;

    @PostMapping("/save")
    public ResponseEntity<VisitDto> save(@RequestBody @Valid SubscribeVisitorDto subscribeVisitorDto){
     return new ResponseEntity<>(visitService.subscribeVisitor(subscribeVisitorDto), HttpStatus.CREATED);
    }
}
