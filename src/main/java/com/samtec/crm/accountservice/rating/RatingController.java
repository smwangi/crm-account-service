package com.samtec.crm.accountservice.rating;

import com.samtec.crm.accountservice.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/api/v1/rating"},produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingController implements BaseController<RatingDto> {

    @Autowired
    private RatingService ratingService;

    @Override
    public ResponseEntity<List<RatingDto>> fetchAll() {
        return ResponseEntity.ok(ratingService.fetchAll());
    }

    @Override
    public ResponseEntity<Optional<RatingDto>> findById(long id) {
        Optional<RatingDto> ratingDto = ratingService.findById(id);
        if(!ratingDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(ratingDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<RatingDto> create(@Valid RatingDto body) {
       try {
           final RatingDto ratingDto = ratingService.save(body);
           return ResponseEntity.ok(ratingDto);
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
       }
    }

    @Override
    @PutMapping
    public Map<String,String> update(long id, @Valid RatingDto body) {
        Optional<RatingDto> ratingDto = ratingService.findById(id);
        if(!ratingDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Rating not found, id: %s",id));
        ratingService.save(body);
        return Map.of("message",String.format("%s updated successfully.",body.getName()));
    }

    @Override
    public Map<String,String> delete(long id) {
        Optional<RatingDto> ratingDto = ratingService.findById(id);
        if(!ratingDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Rating not found, id: %s",id));
        ratingService.delete(id);
        return Map.of("message","Rating deleted successfully");
    }
}
