package com.samtec.crm.accountservice.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityMapper mapper;

    @Override
    public ActivityDto save(ActivityDto activityDto) {
        return mapper.toActivityDto(activityRepository.save(mapper.toActivity(activityDto)));
    }

    @Override
    public Optional<ActivityDto> findById(long id) {
        return Optional.of(mapper.toActivityDto(activityRepository.findById(id).get()));
    }

    @Override
    public List<ActivityDto> fetchAll() {
        return mapper.activityDtoList(activityRepository.findAll());
    }

    //@Override
    public ActivityDto update(ActivityDto activityDto) {
        return mapper.toActivityDto(activityRepository.save(mapper.toActivity(activityDto)));
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
