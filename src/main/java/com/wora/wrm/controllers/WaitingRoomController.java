package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/Waiting-List")
@RequiredArgsConstructor
public class WaitingRoomController {

    private final IWaitingRoomService waitingRoomService;

    @PostMapping("/save")
    public ResponseEntity<WaitingRoomDto> save(@RequestBody @Valid CreateWaitingRoomDto createWaitingRoomDto){
        return new ResponseEntity<>(waitingRoomService.save(createWaitingRoomDto), HttpStatus.CREATED);
    }

}
