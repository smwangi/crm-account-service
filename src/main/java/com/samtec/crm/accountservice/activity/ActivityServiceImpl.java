
package com.samtec.crm.accountservice.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return activityRepository.findById(id)
                .stream()
                .map(mapper::toActivityDto)
                .findFirst();
    }

    @Override
    public List<ActivityDto> fetchAll() {

        return activityRepository.findAll()
                .stream()
                .map(mapper::toActivityDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}