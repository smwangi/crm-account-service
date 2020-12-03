package com.samtec.crm.accountservice.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samtec.crm.accountservice.account.Account;
import com.samtec.crm.accountservice.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "box_address")
    private String boxAddress;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBoxAddress() {
        return boxAddress;
    }

    public void setBoxAddress(String boxAddress) {
        this.boxAddress = boxAddress;
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
