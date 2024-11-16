package com.wora.wrm.services.interfaces;

import com.wora.wrm.models.dtos.visitorDtos.CreateVisitorDto;
import com.wora.wrm.models.dtos.visitorDtos.UpdateVisitorDto;
import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.models.entities.Visitor;
import com.wora.wrm.services.IGenericService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface IVisitorService extends IGenericService<CreateVisitorDto, UpdateVisitorDto, VisitorDto, Long> {
    Visitor getVisitorEntityById(Long id);
    Duration calculateWaitingTime(LocalDateTime arrivalTime, LocalTime startTime);
}
