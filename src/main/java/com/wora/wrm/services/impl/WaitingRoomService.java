package com.wora.wrm.services.impl;

import com.wora.wrm.config.WaitingRoomProperties;
import com.wora.wrm.exceptions.EntityNotFoundException;
import com.wora.wrm.exceptions.NullAlgorithmException;
import com.wora.wrm.mappers.WaitingRoomMapper;
import com.wora.wrm.models.dtos.WaitingRoomDtos.CreateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.UpdateWaitingRoomDto;
import com.wora.wrm.models.dtos.WaitingRoomDtos.WaitingRoomDto;
import com.wora.wrm.models.dtos.visitDto.EmbeddedVisitDto;
import com.wora.wrm.models.entities.WaitingRoom;
import com.wora.wrm.models.enumes.AlgorithmType;
import com.wora.wrm.models.enumes.VisitorStatus;
import com.wora.wrm.repositories.WaitingRoomRepository;
import com.wora.wrm.services.interfaces.IWaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WaitingRoomService implements IWaitingRoomService {
    private final WaitingRoomRepository waitingRoomRepository;
    private final WaitingRoomMapper waitingRoomMapper;
    private final WaitingRoomProperties waitingRoomProperties;

    @Override
    public WaitingRoomDto save(CreateWaitingRoomDto createWaitingRoomDto) {
        WaitingRoom waitingRoom = waitingRoomMapper.toEntity(createWaitingRoomDto);
        setDefaultPropertiesIfNeeded(waitingRoom);
        WaitingRoom savedWaitingRoom = waitingRoomRepository.save(waitingRoom);
        return waitingRoomMapper.toDto(savedWaitingRoom);
    }

    @Override
    public WaitingRoomDto findById(Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waiting Room", id));

        WaitingRoomDto waitingRoomDto = waitingRoomMapper.toDto(waitingRoom);
        List<EmbeddedVisitDto> sortedVisits = algorithmType(waitingRoomDto.visits(), waitingRoomDto.algorithmType());

        return new WaitingRoomDto(
                waitingRoomDto.id(),
                waitingRoomDto.date(),
                waitingRoomDto.algorithmType(),
                waitingRoomDto.capacity(),
                waitingRoomDto.workMode(),
                sortedVisits
        );

    }

    @Override
    public WaitingRoomDto update(UpdateWaitingRoomDto updateWaitingRoomDto, Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waiting Room", id));
        waitingRoom.setDate(updateWaitingRoomDto.date());
        setDefaultPropertiesIfNeeded(waitingRoom);
        WaitingRoom updatedWaitingRoom = waitingRoomRepository.save(waitingRoom);
        return waitingRoomMapper.toDto(updatedWaitingRoom);
    }

    @Override
    public List<WaitingRoomDto> findAll() {
        return waitingRoomRepository.findAll().stream()
                .map(waitingRoom -> {
                    WaitingRoomDto dto = waitingRoomMapper.toDto(waitingRoom);
                    List<EmbeddedVisitDto> sortedVisits = algorithmType(dto.visits(), dto.algorithmType());
                    return new WaitingRoomDto(
                            dto.id(),
                            dto.date(),
                            dto.algorithmType(),
                            dto.capacity(),
                            dto.workMode(),
                            sortedVisits
                    );
                })
                .toList();
    }

    @Override
    public void delete(Long id) {
        WaitingRoom waitingRoom = waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waiting Room", id));
        waitingRoomRepository.delete(waitingRoom);
    }


    private void setDefaultPropertiesIfNeeded(WaitingRoom waitingRoom) {
        if (waitingRoom.getAlgorithmType() == null) {
            waitingRoom.setAlgorithmType(waitingRoomProperties.getDefaultAlgorithmType());
        }
        if (waitingRoom.getCapacity() == null) {
            waitingRoom.setCapacity(waitingRoomProperties.getDefaultCapacity());
        }
        if (waitingRoom.getWorkMode() == null) {
            waitingRoom.setWorkMode(waitingRoomProperties.getDefaultWorkMode());
        }
    }

    private List<EmbeddedVisitDto> algorithmType(List<EmbeddedVisitDto> visits, AlgorithmType algorithmType) {
        List<EmbeddedVisitDto> waitingVisits = visits.stream()
                .filter(visit -> VisitorStatus.WAITING.equals(visit.visitorStatus()))
                .toList();

        switch (algorithmType) {
            case FIFO -> {
                return waitingVisits.stream()
                        .sorted(Comparator.comparing(EmbeddedVisitDto::arrivalTime, Comparator.nullsLast(Comparator.naturalOrder())))
                        .toList();
            }
            case SJF -> {
                return waitingVisits.stream()
                        .sorted(Comparator.comparing(EmbeddedVisitDto::estimatedProcessingTime, Comparator.nullsLast(Comparator.naturalOrder())))
                        .toList();
            }
            case PRIORITY -> {
                return waitingVisits.stream()
                        .sorted(Comparator.comparing(EmbeddedVisitDto::priority, Comparator.nullsLast(Comparator.naturalOrder()))
                                .thenComparing(EmbeddedVisitDto::arrivalTime,
                                        Comparator.nullsLast(Comparator.naturalOrder())))
                        .toList();
            }
            default -> throw new NullAlgorithmException("Unknown algorithm type: " + algorithmType);
        }
    }

    @Override
    public WaitingRoom getWaitingRoomEntityById(Long id){
        return waitingRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Waiting Room", id));
    }
}
