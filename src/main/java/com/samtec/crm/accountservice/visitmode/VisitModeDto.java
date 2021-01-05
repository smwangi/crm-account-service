
package com.samtec.crm.accountservice.visitmode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samtec.crm.accountservice.common.EntityStatus;
import com.samtec.crm.accountservice.visit.Visit;
import com.samtec.crm.accountservice.visit.VisitDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class VisitModeDto {

    @JsonProperty
    private Long id;

    @JsonProperty(required=true,index = 0,value = "name")
    @NotEmpty(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    private String name;

    @JsonProperty(index = 1)
    private String description;

    @JsonIgnore
    private LocalDateTime modifiedAt;

    @JsonIgnore
    private long modifiedBy;

    @JsonIgnore
    private EntityStatus status;

    @JsonProperty
    private Set<VisitDto> visits  = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
     public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }
/**/
    /**/public Set<VisitDto> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDto> visitDto) {
        this.visits = visitDto;
    }

    public long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

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
}
