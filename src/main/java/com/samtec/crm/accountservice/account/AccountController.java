
package com.samtec.crm.accountservice.account;

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
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = {"/api/v1/account"},produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController implements BaseController<AccountDto> {

    @Autowired
    private AccountService accountService;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> fetchAll() {
        return ResponseEntity.ok(accountService.fetchAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountDto>> findById(@PathVariable long id) {
        Optional<AccountDto> accountDto = accountService.findById(id);
        if(!accountDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("No resource found for id (%s)",id));
        return ResponseEntity.ok(accountDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<AccountDto> create(@Valid AccountDto body) {
        try {
            final  AccountDto accountDto = accountService.save(body);
            return ResponseEntity.ok(accountDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    @PutMapping
    public Map<String,String> update(@PathVariable long id, @Valid AccountDto body) {
        final Optional<AccountDto> accountDto = accountService.findById(id);
        if(!accountDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        accountService.save(body);
        return Map.of("message",String.format("Update successful for %s",body.getName()));
    }

    @Override
    @DeleteMapping
    public Map<String,String> delete(long id) {
        Optional<AccountDto> accountDto = accountService.findById(id);
        if(!accountDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not delete a non-existent record");
        accountService.delete(id);
        return Map.of("message",String.format("Deletion Successful for Account with id: %s",id));
    }
}
