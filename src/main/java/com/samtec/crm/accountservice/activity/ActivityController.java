package com.samtec.crm.accountservice.activity;

import com.samtec.crm.accountservice.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/api/v1/activity"},produces = MediaType.APPLICATION_JSON_VALUE)
public class ActivityController implements BaseController<ActivityDto> {

    @Autowired
    private ActivityService activityService;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<ActivityDto>> fetchAll() {
        return ResponseEntity.ok(activityService.fetchAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ActivityDto>> findById(@PathVariable long id) {
        Optional<ActivityDto> activityDto = activityService.findById(id);
        if(!activityDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(activityDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<ActivityDto> create(@Valid ActivityDto body) {
        try {
            final ActivityDto activityDto = activityService.save(body);
            return ResponseEntity.ok(activityDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    @PutMapping
    public Map<String,String> update(long id, @Valid ActivityDto body) {
        Optional<ActivityDto> activityDto = activityService.findById(id);
        if(!activityDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        activityService.save(body);
        return Map.of("message",String.format("Update successful for %s",body.getName()));
    }

    @Override
    public Map<String,String> delete(long id) {
        Optional<ActivityDto> activityDto = activityService.findById(id);
        if(!activityDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        activityService.delete(id);
        return Map.of("message",String.format("Deletion Successful for Activity with id: %s",id));
    }
}
