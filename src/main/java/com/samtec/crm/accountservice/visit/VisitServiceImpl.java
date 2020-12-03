package com.samtec.crm.accountservice.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitMapper mapper;

    @Override
    public VisitDto save(VisitDto visitDto) {
        return mapper.toVisitDto(visitRepository.save(mapper.toVisit(visitDto)));
    }

    @Override
    public Optional<VisitDto> findById(long id) {

        return Optional.of(mapper.toVisitDto(visitRepository.getOne(id)));
    }

    @Override
    public List<VisitDto> fetchAll() {
        return mapper.visitDtoList(visitRepository.findAll());
    }

    //@Override
    public VisitDto update(VisitDto visitDto) {

        return mapper.toVisitDto(visitRepository.save(mapper.toVisit(visitDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
