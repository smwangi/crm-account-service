
package com.samtec.crm.accountservice.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        return visitRepository.findById(id)
                .stream()
                .map(mapper::toVisitDto)
                .findFirst();
    }

    @Override
    public List<VisitDto> fetchAll() {

        return visitRepository.findAll()
                .stream()
                .map(mapper::toVisitDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
