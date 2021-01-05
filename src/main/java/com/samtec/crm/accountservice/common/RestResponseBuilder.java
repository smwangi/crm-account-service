
package com.samtec.crm.accountservice.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

public class RestResponseBuilder {
    private int status;
    private String error;
    private String message;
    private String path;

    public RestResponseBuilder status(int status){
        this.status = status;
        return this;
    }

    public RestResponseBuilder status(HttpStatus status){
        this.status = status.value();
        if(status.isError()){
            this.error = status.getReasonPhrase();
        }
        return this;
    }
    public RestResponseBuilder exception(ResponseStatusException exception){
        HttpStatus status = exception.getStatus();
        this.status = status.value();

        if(!Objects.requireNonNull(exception.getReason()).isBlank()){
            this.message = exception.getReason();
        }
        if(status.isError()){
            this.error = status.getReasonPhrase();
        }
        return this;
    }

    public RestResponseBuilder message(String message){
        this.message = message;
        return this;
    }

    public RestResponseBuilder path(String path){
        this.path = path;
        return this;
    }
    public RestResponse build(){
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(status);
        restResponse.setError(error);
        restResponse.setMessage(message);
        restResponse.setPath(path);
        return restResponse;
    }
    public ResponseEntity<RestResponse> entity(){
        return ResponseEntity.status(status).headers(HttpHeaders.EMPTY).body(build());
    }
}
