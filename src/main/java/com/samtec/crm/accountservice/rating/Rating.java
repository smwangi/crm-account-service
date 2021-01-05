
package com.samtec.crm.accountservice.rating;

import com.samtec.crm.accountservice.account.Account;
import com.samtec.crm.accountservice.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",length = 300)
    private String description;

    @OneToMany(mappedBy = "rating")
    private Set<Account>accounts = new HashSet<>();

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
}
