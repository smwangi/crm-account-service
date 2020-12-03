package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.visit.Visit;
import com.samtec.crm.accountservice.visit.VisitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper(componentModel = "spring")
public interface VisitModeMapper {
    VisitModeDto toVisitModeDto(VisitMode visitMode);
    VisitMode toVisitMode(VisitModeDto visitModeDto);
    List<VisitModeDto> toVisitModeDtoList(List<VisitMode> visitModeList);
    VisitDto map(Visit visit);
    Visit map(VisitDto visitDto);

    @Named("unwrap")
    default <T> T unwrap(Optional<T> optional){
        return optional.orElse(null);
    }

    /**
     * @Mapping(source = "child", target = "kid", qualifiedByName = "unwrap")
     *     Target map(Source source);
     *
     *     @Named("unwrap")
     *     default <T> T unwrap(Optional<T> optional) {
     *         return optional.orElse(null);
     *     }
     */
}
