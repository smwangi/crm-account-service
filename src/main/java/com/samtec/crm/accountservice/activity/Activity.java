package com.samtec.crm.accountservice.activity;

import com.samtec.crm.accountservice.common.BaseEntity;
import com.samtec.crm.accountservice.update.AccountUpdate;
import com.samtec.crm.accountservice.visit.Visit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "activity")
    private Set<Visit> visits = new HashSet<>();

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
    public long getModifiedBy() {
        return super.getModifiedBy();
    }

    @Override
    public void setModifiedBy(long modifiedBy) {
        super.setModifiedBy(modifiedBy);
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
    public Long getId() {
        return super.getId();
    }

}
