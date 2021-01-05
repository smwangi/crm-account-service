package com.samtec.crm.accountservice.activity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-05T22:04:56+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
@Component
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public ActivityDto toActivityDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        activityDto.setName( activity.getName() );
        activityDto.setDescription( activity.getDescription() );
        activityDto.setId( activity.getId() );
        if ( activity.getModifiedAt() != null ) {
            activityDto.setModifiedAt( LocalDateTime.ofInstant( activity.getModifiedAt().toInstant(), ZoneId.of( "UTC" ) ) );
        }

        return activityDto;
    }

    @Override
    public Activity toActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setId( activityDto.getId() );
        activity.setName( activityDto.getName() );
        activity.setDescription( activityDto.getDescription() );
        if ( activityDto.getModifiedAt() != null ) {
            activity.setModifiedAt( Date.from( activityDto.getModifiedAt().toInstant( ZoneOffset.UTC ) ) );
        }

        return activity;
    }

    @Override
    public List<ActivityDto> activityDtoList(List<Activity> activityList) {
        if ( activityList == null ) {
            return null;
        }

        List<ActivityDto> list = new ArrayList<ActivityDto>( activityList.size() );
        for ( Activity activity : activityList ) {
            list.add( toActivityDto( activity ) );
        }

        return list;
    }
}
