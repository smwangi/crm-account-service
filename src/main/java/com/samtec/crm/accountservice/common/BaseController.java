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

    public ResponseEntity<List<T>> fetchAll();
    public ResponseEntity<Optional<T>> findById(@PathVariable long id);
    public ResponseEntity<T>create(@Valid @RequestBody T body);
    public Map<String,String>update(@PathVariable long id,@Valid @RequestBody T body);
    public Map<String,String> delete(@PathVariable long id);
}
