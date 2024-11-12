package com.wora.wrm.services.impl;

import com.wora.wrm.exceptions.EntityNotFoundException;
import com.wora.wrm.mappers.WaitingRoomMapper;
import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.models.entities.WaitingRoom;
import com.wora.wrm.repositories.WaitingRoomRepository;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WaitingRoomService implements IWaitingRoomService {
    private final WaitingRoomRepository waitingRoomRepository;
    private final WaitingRoomMapper waitingRoomMapper;

    @Override
    public WaitingRoomDto save(CreateWaitingRoomDto createWaitingRoomDto) {
        WaitingRoom waitingRoom = waitingRoomMapper.toEntity(createWaitingRoomDto);
        WaitingRoom savedWaitingRoom = waitingRoomRepository.save(waitingRoom);
        return waitingRoomMapper.toDto(savedWaitingRoom);
    }

    @Override
    public WaitingRoomDto findById(Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waiting Room", id));
        return waitingRoomMapper.toDto(waitingRoom);
    }

    @Override
    public WaitingRoomDto update(UpdateWaitingRoomDto updateWaitingRoomDto) {
        return null;
    }

    @Override
    public List<WaitingRoomDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
