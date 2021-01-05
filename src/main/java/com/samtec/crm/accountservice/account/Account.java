
package com.samtec.crm.accountservice.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samtec.crm.accountservice.address.Address;
import com.samtec.crm.accountservice.common.BaseEntity;
import com.samtec.crm.accountservice.industry.Industry;
import com.samtec.crm.accountservice.rating.Rating;
import com.samtec.crm.accountservice.type.AccountType;
import com.samtec.crm.accountservice.visit.Visit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "industry_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Industry industry;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "account_type_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "rating_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Rating rating;

    @OneToMany(mappedBy = "account")
    private Set<Address> addresses = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
