package com.samtec.crm.accountservice.industry;

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
@RequestMapping(path = {"/api/v1/industry"},produces = MediaType.APPLICATION_JSON_VALUE)
public class IndustryController implements BaseController<IndustryDto> {

    @Autowired
    private IndustryService industryService;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<IndustryDto>> fetchAll() {
        return ResponseEntity.ok(industryService.fetchAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<IndustryDto>> findById(long id) {
        Optional<IndustryDto> industryDto = industryService.findById(id);
        if(industryDto.isPresent())
            return ResponseEntity.ok(industryDto);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping
    public ResponseEntity<IndustryDto> create(@Valid IndustryDto body) {
        try {
            final IndustryDto industryDto =  industryService.save(body);
            return ResponseEntity.ok(industryDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    @PutMapping
    public Map<String,String> update(long id, @Valid IndustryDto body) {
        Optional<IndustryDto> industryDto = industryService.findById(id);
        if(!industryDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        final  IndustryDto industryDto1 = industryService.save(body);
        return Map.of("message",String.format("Update successful for %s",body.getName()));
    }

    @Override
    @DeleteMapping
    public Map<String,String> delete(long id) {
        Optional<IndustryDto> industryDto = industryService.findById(id);
        if(!industryDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not delete a non-existent record");
        industryService.delete(id);
        return Map.of("message",String.format("Deletion Successful for Industry with id: %s",id));
    }
}
