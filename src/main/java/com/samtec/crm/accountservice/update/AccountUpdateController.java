
package com.samtec.crm.accountservice.update;

import com.samtec.crm.accountservice.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/api/v1/accountupdate"},produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountUpdateController implements BaseController<AccountUpdateDto> {

    @Autowired
    private AccountUpdateService accountUpdateService;

    @Override
    public ResponseEntity<List<AccountUpdateDto>> fetchAll() {
        return ResponseEntity.ok(accountUpdateService.fetchAll());
    }

    @Override
    public ResponseEntity<Optional<AccountUpdateDto>> findById(long id) {
        Optional<AccountUpdateDto> accountUpdateDto = accountUpdateService.findById(id);
        if(!accountUpdateDto.isPresent())
            return ResponseEntity.unprocessableEntity().build();
        return ResponseEntity.ok(accountUpdateDto);
    }

    @Override
    public ResponseEntity<AccountUpdateDto> create(@Valid AccountUpdateDto body) {
        try {
            final AccountUpdateDto accountUpdateDto = accountUpdateService.save(body);
            return ResponseEntity.ok(accountUpdateDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    public Map<String,String> update(@PathVariable long id, @Valid AccountUpdateDto body) {
        Optional<AccountUpdateDto> accountUpdateDto = accountUpdateService.findById(id);
        if(!accountUpdateDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Update with id: (%s) not found.",id));

        accountUpdateService.save(body);
        return Map.of("message","Update is successful.");
    }

    @Override
    public Map<String,String> delete(long id) {
        Optional<AccountUpdateDto> accountUpdateDto = accountUpdateService.findById(id);
        if(!accountUpdateDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Entity with id: (%s) not founc",id));
        accountUpdateService.delete(id);
        return Map.of("message","Account Update Deleted Successfully");
    }
}
