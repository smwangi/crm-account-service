
package com.samtec.crm.accountservice.address;

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
@RequestMapping(path = {"/api/v1/address"},produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController implements BaseController<AddressDto> {

    @Autowired
    private AddressService addressService;

    @Override
    @GetMapping
    public ResponseEntity<List<AddressDto>> fetchAll() {
        return ResponseEntity.ok(addressService.fetchAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressDto>> findById(@PathVariable long id) {
        Optional<AddressDto> addressDto = addressService.findById(id);
        if(!addressDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(addressDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<AddressDto> create(@Valid AddressDto body) {
        try {
            final AddressDto addressDto = addressService.save(body);
            return ResponseEntity.ok(addressDto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @Override
    @PutMapping
    public Map<String,String> update(@PathVariable long id, @Valid AddressDto body) {
        Optional<AddressDto> addressDto = addressService.findById(id);
        if(!addressDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        addressService.save(body);
        return Map.of("message",String.format("Update successful for %s",body.getEmail()));
    }

    @Override
    @DeleteMapping
    public Map<String,String> delete(@PathVariable long id) {
        Optional<AddressDto> addressDto = addressService.findById(id);
        if(!addressDto.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not delete a non-existent record");
        addressService.delete(id);
        return Map.of("message",String.format("Deletion Successful for Address with id: %s",id));
    }
}
