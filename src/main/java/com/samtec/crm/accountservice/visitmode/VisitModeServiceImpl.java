package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.common.EntityStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      /* VisitMode visitMode = mapper.toVisitMode(visitModeDto);
       visitMode.setStatus(EntityStatus.CREATED);
       VisitModeDto dto = mapper.toVisitModeDto(visitModeRepository.save(visitMode));
       return dto;*/
        return mapper.toVisitModeDto(visitModeRepository.save(mapper.toVisitMode(visitModeDto)));
    }

    @Override
    public Optional<VisitModeDto> findById(long id) {
        logger.info("Visit Mode Id: "+id);
        final Optional<VisitMode> visitMode = visitModeRepository.findById(id);

        return Optional.of(mapper.toVisitModeDto(mapper.unwrap(visitMode)));// Optional.of(mapper.toVisitModeDto(visitMode));
    }

    @Override
    public List<VisitModeDto> fetchAll() {
        return mapper.toVisitModeDtoList(visitModeRepository.findAll());
    }

    //@Override
    public VisitModeDto update(VisitModeDto visitModeDto) {
        return mapper.toVisitModeDto(visitModeRepository.save(mapper.toVisitMode(visitModeDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

  }
