package com.wora.wrm.services.interfaces;

import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.services.IGenericService;

public interface IWaitingRoomService extends IGenericService<CreateWaitingRoomDto, UpdateWaitingRoomDto, WaitingRoomDto, Long> {
}
