package com.samtec.crm.accountservice.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BaseController<T> {

    ResponseEntity<List<T>> fetchAll();
    ResponseEntity<Optional<T>> findById(@PathVariable long id);
    ResponseEntity<T>create(@Valid @RequestBody T body);
    Map<String,String>update(@PathVariable long id,@Valid @RequestBody T body);
    Map<String,String> delete(@PathVariable long id);
}
