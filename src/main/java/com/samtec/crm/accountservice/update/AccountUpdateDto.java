package com.samtec.crm.accountservice.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountUpdateDto {

    @JsonProperty
    @NotEmpty
    @NotBlank
    private String subject;

    @JsonProperty
    @NotBlank
    @NotEmpty
    private String description;

    @JsonProperty
    @NotEmpty
    @NotBlank
    private String nextAction;

    @JsonProperty
    @NotBlank
    @NotEmpty
    private LocalDate date;

    @JsonProperty
    @NotEmpty
    @NotBlank
    private LocalDate nextActionDate;

    @JsonProperty
    private Long id;

    @JsonProperty
    private LocalDateTime modifiedAt;

    @JsonProperty
    private Long modifiedBy;

    private long accountId;

    private long activityId;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getNextActionDate() {
        return nextActionDate;
    }

    public void setNextActionDate(LocalDate nextActionDate) {
        this.nextActionDate = nextActionDate;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
