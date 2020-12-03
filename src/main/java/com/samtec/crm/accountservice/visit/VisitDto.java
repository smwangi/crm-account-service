package com.samtec.crm.accountservice.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class VisitDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long modifiedBy;

    @JsonProperty
    private LocalDateTime modifiedAt;

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
