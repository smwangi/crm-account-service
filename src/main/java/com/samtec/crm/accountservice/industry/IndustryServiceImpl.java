
package com.samtec.crm.accountservice.industry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryRepository industryRepository;

    @Autowired
    private IndustryMapper mapper;

    @Override
    public IndustryDto save(IndustryDto industryDto) {
        return mapper.toIndustryDto(mapper.toIndustry(industryDto));
    }

    @Override
    public Optional<IndustryDto> findById(long id) {
        return industryRepository.findById(id)
                .stream()
                .map(mapper::toIndustryDto)
                .findFirst();
    }

    @Override
    public List<IndustryDto> fetchAll() {
        return industryRepository.findAll()
                .stream()
                .map(mapper::toIndustryDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}