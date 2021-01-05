
package com.samtec.crm.accountservice.industry;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IndustryMapper {

    IndustryDto toIndustryDto(Industry industry);
    Industry toIndustry(IndustryDto industryDto);
}