package com.samtec.crm.accountservice.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActivityDto {
    @JsonProperty
    @NotEmpty
    @NotBlank
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private Long id;

    @JsonProperty
    private LocalDateTime modifiedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
