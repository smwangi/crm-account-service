package com.samtec.crm.accountservice.type;

import com.samtec.crm.accountservice.account.Account;
import com.samtec.crm.accountservice.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account_types")
public class AccountType extends BaseEntity {

    @Column(name = "name",nullable = false,length = 200)
    private String name;

    @Column(name = "description",length = 350)
    private String description;

    @OneToMany(mappedBy = "accountType",cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

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

    @Override
    public Date getModifiedAt() {
        return super.getModifiedAt();
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public void setModifiedAt(Date modifiedAt) {
        super.setModifiedAt(modifiedAt);
    }
}
