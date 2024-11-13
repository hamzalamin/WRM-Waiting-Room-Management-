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
        return null;
    }

    @Override
    public VisitorDto findById(Long id){
        Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visitor", id));
        return visitorMapper.toDto(visitor);
    }

    @Override
    public VisitorDto update(UpdateVisitorDto updateVisitorDto, Long id) {
        return null;
    }

    @Override
    public List<VisitorDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
