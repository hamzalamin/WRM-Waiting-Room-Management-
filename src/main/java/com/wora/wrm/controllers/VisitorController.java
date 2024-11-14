package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.visitorDtos.CreateVisitorDto;
import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.services.interfaces.IVisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/visitor/")
@RequiredArgsConstructor
public class VisitorController {

    private final IVisitorService visitorService;

    @GetMapping("/{id}")
    public ResponseEntity<VisitorDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(visitorService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VisitorDto>> findAll(){
        List<VisitorDto> visitorList = visitorService.findAll();
        return new ResponseEntity<>(visitorList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<VisitorDto> save(@RequestBody @Valid CreateVisitorDto createVisitorDto){
        return new ResponseEntity<>(visitorService.save(createVisitorDto), HttpStatus.CREATED);
    }
}
