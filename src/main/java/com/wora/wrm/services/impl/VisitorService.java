package com.wora.wrm.services.impl;

import com.wora.wrm.exceptions.EntityNotFoundException;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.repositories.VisitorRepository;
import com.wora.wrm.services.interfaces.IVisitorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VisitorService implements IVisitorService {

    private final VisitorRepository visitorRepository;

    @Override
    public Visitor getVisitorEntityById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visitor", id));
    }
}
