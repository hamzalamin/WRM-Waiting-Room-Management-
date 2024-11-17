package com.wora.wrm.services;

import java.awt.print.Pageable;
import java.util.List;

public interface IGenericService<CREATE_DTO, UPDATE_DTO, DTO, ID> {
    DTO save(CREATE_DTO createDto);
    DTO findById(ID id);
    DTO update(UPDATE_DTO updateDto, ID id);
    List<DTO> findAll(int page, int size);
    void delete(ID id);
}
