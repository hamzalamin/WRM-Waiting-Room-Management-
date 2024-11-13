package com.wora.wrm.mappers;

import com.wora.wrm.mappers.api.GenericMapper;
import com.wora.wrm.models.dtos.visitorDtos.VisitorDto;
import com.wora.wrm.models.entities.Visitor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitorMapper extends GenericMapper<Visitor, VisitorDto> {
    @Mapping(source = "FName", target = "fName")
    @Mapping(source = "LName", target = "lName")
    @Mapping(source = "visits", target = "visitDtoList")
    VisitorDto toDto(Visitor visitor);

    @Mapping(source = "fName", target = "FName")
    @Mapping(source = "lName", target = "LName")
    @Mapping(source = "visitDtoList", target = "visits")
    Visitor toEntity(VisitorDto visitorDto);
}
