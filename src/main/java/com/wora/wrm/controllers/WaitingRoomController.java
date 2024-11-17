package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/api/v1/Waiting-List")
@RequiredArgsConstructor
public class WaitingRoomController {

    private final IWaitingRoomService waitingRoomService;

    @PostMapping("/save")
    public ResponseEntity<WaitingRoomDto> save(@RequestBody @Valid CreateWaitingRoomDto createWaitingRoomDto){
        return new ResponseEntity<>(waitingRoomService.save(createWaitingRoomDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/find")
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

    @GetMapping("/findAll")
    public ResponseEntity<List<WaitingRoomDto>> findAll(
            @RequestParam int page,
            @RequestParam int size
    ){
        List<WaitingRoomDto> waitingRoomDtoList = waitingRoomService.findAll(page, size);
        return new ResponseEntity<>(waitingRoomDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<String> delete(@PathVariable Long id){
        waitingRoomService.delete(id);
        return new ResponseEntity<>("WAITING ROOM " +id+ " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

}
