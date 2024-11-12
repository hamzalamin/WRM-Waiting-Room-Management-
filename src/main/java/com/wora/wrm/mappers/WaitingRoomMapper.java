package com.wora.wrm.mappers;

import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.models.entities.WaitingRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WaitingRoomMapper extends GenericMapper<WaitingRoom, WaitingRoomDto> {
    WaitingRoom toEntity(WaitingRoomDto waitingRoomDto);
    WaitingRoom toEntity(CreateWaitingRoomDto createWaitingRoomDto);
    WaitingRoom toEntity(UpdateWaitingRoomDto updateWaitingRoomDto);
    WaitingRoomDto toDto(WaitingRoom waitingRoom);
}
