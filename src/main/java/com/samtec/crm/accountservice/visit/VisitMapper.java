
package com.samtec.crm.accountservice.visit;

import com.samtec.crm.accountservice.visitmode.VisitModeDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDto toVisitDto(Visit visit);
    Visit toVisit(VisitDto visitDto);
    List<VisitDto> visitDtoList(List<Visit>visitList);
}
