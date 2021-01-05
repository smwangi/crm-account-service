
package com.samtec.crm.accountservice.activity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityDto toActivityDto(Activity activity);
    Activity toActivity(ActivityDto activityDto);
    List<ActivityDto> activityDtoList(List<Activity> activityList);
}