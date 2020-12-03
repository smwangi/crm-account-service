package com.samtec.crm.accountservice.visitmode;

import org.apache.tomcat.jni.Library;
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
@RequestMapping(path = {"api/v1/visitmodes"},produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitModeController {

    @Autowired
    private VisitModeService visitModeService;

    /*@GetMapping(path = {"/"})
    public ResponseEntity<?>getAll(){
        return ResponseEntity.ok(visitModeService.fetchAll());
    }
*/
    @RequestMapping("/test")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @GetMapping(path = {"/"})
    public List<VisitModeDto> fetchAll(){
        return visitModeService.fetchAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?>getOne(@PathVariable long id){
        final Optional<VisitModeDto> visitModeDto = visitModeService.findById(id);
        if(visitModeDto.isPresent())
            return ResponseEntity.ok(visitModeDto);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VisitModeDto>create(@Valid @RequestBody VisitModeDto visitModeDto){
        try {
            final VisitModeDto vModeDto = visitModeService.save(visitModeDto);
            return ResponseEntity.ok(vModeDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Map<String,String> update(@PathVariable long id,@Valid @RequestBody VisitModeDto visitModeDto){
        Optional<VisitModeDto>visitModeDtoOptional = visitModeService.findById(id);
        if(!visitModeDtoOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        visitModeService.save(visitModeDto);
        return Map.of("message",String.format("Update successful for %s",visitModeDto.getName()));
    }

    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable Integer id){
        Optional<VisitModeDto> visitModeOptional = visitModeService.findById(id);
        if(!visitModeOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not delete a non-existent record");
        }
        visitModeService.delete(id);
        return Map.of("message",String.format("Deletion Successful for Visit Mode with id: %s",id));
    }
}
