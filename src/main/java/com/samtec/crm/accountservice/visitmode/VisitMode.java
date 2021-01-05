
package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.common.BaseEntity;
import com.samtec.crm.accountservice.common.EntityStatus;
import com.samtec.crm.accountservice.visit.Visit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visit_modes")
@Getter
@Setter
public class VisitMode extends BaseEntity {

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    private String description;

    @Column(name = "status_id")
    @Enumerated(EnumType.ORDINAL)
    private EntityStatus status;

    @OneToMany(mappedBy = "visitMode",cascade = CascadeType.ALL)
    private Set<Visit> visits  = new HashSet<>();

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

   /* public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }*/

    @Override
    public int hashCode() {
        int result = 17;
        if(name != null)
            result = 31*result+name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)return true;
        if(!(obj instanceof VisitMode))
            return false;
        VisitMode visitMode = (VisitMode) obj;
        boolean idEquals = (this.getId() == null && visitMode.getId() == null)
                || (this.getId() != null && this.getId().equals(visitMode.getId()));
        boolean nameEquals = (this.getName() == null && visitMode.getName() == null)
                || (this.getId() != null && this.getName().equals(visitMode.getName()));

        return idEquals && nameEquals;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
