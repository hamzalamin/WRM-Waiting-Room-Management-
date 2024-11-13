package com.wora.wrm.controllers;

import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.services.interfaces.IVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/visitor/")
@RequiredArgsConstructor
public class VisitorController {

    private final IVisitorService visitorService;

    @GetMapping("/{id}")
    public ResponseEntity<VisitorDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(visitorService.findById(id), HttpStatus.OK);
    }
}
