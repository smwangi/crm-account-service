package com.samtec.crm.accountservice.visit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samtec.crm.accountservice.account.Account;
import com.samtec.crm.accountservice.activity.Activity;
import com.samtec.crm.accountservice.common.BaseEntity;
import com.samtec.crm.accountservice.visitmode.VisitMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visits")
public class Visit  extends BaseEntity {

    //@Column(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "account_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    @Column(name = "reason")
    private String reason;

    @Column(name = "visit_date")
    //@Temporal(TemporalType.DATE)
    private LocalDateTime date;

    @Column(name = "visit_status_id")
    @Enumerated(EnumType.ORDINAL)
    private  VisitStatus status;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "visit_mode_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VisitMode visitMode;

    @Column(name = "next_action")
    private String nextAction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Activity activity;

    //@Temporal(TemporalType.DATE)
    @Column(name = "next_action_date")
    private LocalDate nextActionDate;

    @Lob
    @Column(name = "present")
    private String present;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public Date getModifiedAt() {
        return super.getModifiedAt();
    }

    @Override
    public void setModifiedAt(Date modifiedAt) {
        super.setModifiedAt(modifiedAt);
    }

    @Override
    public long getModifiedBy() {
        return super.getModifiedBy();
    }

    @Override
    public void setModifiedBy(long modifiedBy) {
        super.setModifiedBy(modifiedBy);
    }
    /*@OneToMany(mappedBy = "visit",cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();*/
}
