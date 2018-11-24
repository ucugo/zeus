package com.mahull.zeus.domain.advertiser;

import com.mahull.zeus.domain.user.ZeusUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advertisers")
public class Advertiser {

    private static final long serialVersionUID = -3118494043665584808L;

    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne(optional = false)
    private ZeusUser pollen8User;
    @OneToMany(mappedBy = "advertiser")
    private List<Campaign> campaigns;
    @NotNull
    private String advertiserName;
    @NotNull
    private String companyName;
    @NotNull
    private String contactNumber;
    @NotNull
    private String address;
    @NotNull
    private String country;

    @Column(name="include_cpa_code")
    private boolean includeCPACode = true;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ZeusUser getPollen8User() {
        return pollen8User;
    }

    public void setPollen8User(ZeusUser pollen8User) {
        this.pollen8User = pollen8User;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIncludeCPACode() {
        return includeCPACode;
    }

    public void setIncludeCPACode(boolean includeCPACode) {
        this.includeCPACode = includeCPACode;
    }
}
