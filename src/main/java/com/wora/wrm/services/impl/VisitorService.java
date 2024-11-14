package com.wora.wrm.services.impl;

import com.wora.wrm.exceptions.EntityNotFoundException;
import com.wora.wrm.mappers.VisitorMapper;
import com.wora.wrm.models.dtos.visitorDtos.CreateVisitorDto;
import com.wora.wrm.models.dtos.visitorDtos.UpdateVisitorDto;
import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.repositories.VisitorRepository;
import com.wora.wrm.services.interfaces.IVisitorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VisitorService implements IVisitorService {

    private final VisitorRepository visitorRepository;
    private final VisitorMapper visitorMapper;
    @Override
    public Visitor getVisitorEntityById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visitor", id));
    }

    @Override
    public VisitorDto save(CreateVisitorDto createVisitorDto) {
        Visitor visitor = visitorMapper.toEntity(createVisitorDto);
        Visitor savedVisitor = visitorRepository.save(visitor);
        return visitorMapper.toDto(savedVisitor);
    }

    @Override
    public VisitorDto findById(Long id){
        Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visitor", id));
        System.out.println("AKHLOU AYAAAAAD :  first name: " + visitor.getFName() + " last name : " + visitor.getLName());
        VisitorDto visitorDto = visitorMapper.toDto(visitor);
        System.out.println("AKHLOU AYAAAAAD DTO :  first name: " + visitorDto.fName() + " last name : " + visitorDto.lName());
        return visitorDto;
    }

    @Override
    public VisitorDto update(UpdateVisitorDto updateVisitorDto, Long id) {
        return null;
    }

    @Override
    public List<VisitorDto> findAll() {
        return visitorRepository.findAll().stream()
                .map(visitorMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {

    }
}
