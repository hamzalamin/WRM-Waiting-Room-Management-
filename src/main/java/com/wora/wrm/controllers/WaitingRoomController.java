package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/Waiting-List")
@RequiredArgsConstructor
public class WaitingRoomController {

    private final IWaitingRoomService waitingRoomService;

    @PostMapping("/save")
    public ResponseEntity<WaitingRoomDto> save(@RequestBody @Valid CreateWaitingRoomDto createWaitingRoomDto){
        return new ResponseEntity<>(waitingRoomService.save(createWaitingRoomDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaitingRoomDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(waitingRoomService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<WaitingRoomDto> update(
            @PathVariable Long id,
            @RequestBody UpdateWaitingRoomDto updateWaitingRoomDto
    ){
        return new ResponseEntity<>(waitingRoomService.update(updateWaitingRoomDto, id), HttpStatus.CREATED);
    }

}
