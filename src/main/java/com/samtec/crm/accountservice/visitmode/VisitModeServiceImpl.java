
package com.samtec.crm.accountservice.visitmode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class VisitModeServiceImpl implements VisitModeService {

    private static final Logger logger = LoggerFactory.getLogger(VisitModeServiceImpl.class);

    @Autowired
    private VisitModeMapper mapper;

    @Autowired
    private VisitModeRepository visitModeRepository;

    @Override
    public VisitModeDto save(VisitModeDto visitModeDto) {
        return mapper.toVisitModeDto(visitModeRepository.save(mapper.toVisitMode(visitModeDto)));
    }

    @Override
    public Optional<VisitModeDto> findById(long id) {
        logger.info("Visit Mode Id: "+id);
//        final Optional<VisitMode> visitMode = visitModeRepository.findById(id);

        //return Optional.of(mapper.toVisitModeDto(mapper.unwrap(visitMode)));// Optional.of(mapper.toVisitModeDto(visitMode));
        return visitModeRepository.findById(id)
                .stream()
                .map(mapper::toVisitModeDto)
                .findFirst();
    }

    @Override
    public List<VisitModeDto> fetchAll() {

        return visitModeRepository.findAll()
                .stream()
                .map(mapper::toVisitModeDto)
                .collect(Collectors.toList());
    }


    @Override
    public boolean delete(long id) {
        return false;
    }

  }
