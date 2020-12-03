package com.samtec.crm.accountservice.industry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return Optional.of(mapper.toIndustryDto(industryRepository.findById(id).get()));
    }

    @Override
    public List<IndustryDto> fetchAll() {
        return mapper.toIndustryDtoList(industryRepository.findAll());
    }

    //@Override
    public IndustryDto update(IndustryDto industryDto) {
        return mapper.toIndustryDto(industryRepository.save(mapper.toIndustry(industryDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
