package com.samtec.crm.accountservice.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class AddressDto {

    @JsonProperty
    private String email;

    @JsonProperty
    private String website;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String postalCode;

    @JsonProperty
    private String boxAddress;

    @JsonProperty
    private String mobilePhone;

    @JsonProperty
    private Long id;

    @JsonProperty
    private LocalDateTime modifiedAt;


    public String getBoxAddress() {
        return boxAddress;
    }

    public void setBoxAddress(String boxAddress) {
        this.boxAddress = boxAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
