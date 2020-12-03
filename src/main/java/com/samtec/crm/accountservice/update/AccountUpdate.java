package com.samtec.crm.accountservice.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samtec.crm.accountservice.account.Account;
import com.samtec.crm.accountservice.activity.Activity;
import com.samtec.crm.accountservice.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "account_updates")
public class AccountUpdate extends BaseEntity {

    @Column(name = "subject",nullable = false)
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "next_action")
    private String nextAction;

    //@Temporal(TemporalType.DATE)
    @Column(name = "action_date")
    private LocalDate date;

    //@Temporal(TemporalType.DATE)
    @Column(name = "next_action_date")
    private LocalDate nextActionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_update_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Activity activity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getNextActionDate() {
        return nextActionDate;
    }

    public void setNextActionDate(LocalDate nextActionDate) {
        this.nextActionDate = nextActionDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNextAction() {
        return nextAction;
    }

    public void setNextAction(String nextAction) {
        this.nextAction = nextAction;
    }

    @Override
    public long getModifiedBy() {
        return super.getModifiedBy();
    }

    @Override
    public void setModifiedBy(long modifiedBy) {
        super.setModifiedBy(modifiedBy);
    }
}
