package com.samtec.crm.accountservice.type;

import com.samtec.crm.accountservice.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/api/v1/accounttype"},produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountTypeController implements BaseController<AccountTypeDto> {

    @Autowired
    private AccountTypeService accountTypeService;

    @Override
    @GetMapping(path = {"/"})
    public ResponseEntity<List<AccountTypeDto>> fetchAll() {
        return ResponseEntity.ok(accountTypeService.fetchAll());
    }

    @Override
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Optional<AccountTypeDto>> findById(long id) {
        final Optional<AccountTypeDto> accountTypeDto = accountTypeService.findById(id);

        if(accountTypeDto.isPresent())
            return ResponseEntity.ok(accountTypeDto);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping
    public ResponseEntity<AccountTypeDto> create(@Valid AccountTypeDto body) {
        try {
            final AccountTypeDto accountTypeDto = accountTypeService.save(body);
            return ResponseEntity.ok(accountTypeDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    @PutMapping
    public Map<String,String> update(@PathVariable long id, @Valid AccountTypeDto body) {
        Optional<AccountTypeDto> accountTypeDto = accountTypeService.findById(id);
        if(!accountTypeDto.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Account type with id: %s not found",id));
        }
        accountTypeService.save(body);
        return Map.of("message","Account type updated successful");
    }

    @Override
    @DeleteMapping
    public Map<String,String> delete(long id) {
        Optional<AccountTypeDto> accountTypeDto = accountTypeService.findById(id);
        if(!accountTypeDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Account type not found, id: %s",id));

        accountTypeService.delete(id);
        return Map.of("message","Account type deleted successfully.");
    }
}
