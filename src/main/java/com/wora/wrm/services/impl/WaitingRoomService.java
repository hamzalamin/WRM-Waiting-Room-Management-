package com.wora.wrm.services.impl;

import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.repositories.WaitingRoomRepository;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WaitingRoomService implements IWaitingRoomService {
    private final WaitingRoomRepository waitingRoomRepository;

    @Override
    public WaitingRoomDto save(CreateWaitingRoomDto createWaitingRoomDto) {
        return null;
    }

    @Override
    public WaitingRoomDto findById(Long aLong) {
        return null;
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
    public void delete(Long aLong) {

    }
}
