package com.samtec.crm.accountservice.type;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AccountTypeDto {
    @JsonProperty
    @NotEmpty
    @NotBlank
    private String name;

    @JsonProperty
    @NotEmpty
    @NotBlank
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
