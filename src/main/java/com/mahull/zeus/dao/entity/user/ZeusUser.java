package com.mahull.zeus.dao.entity.user;

import com.mahull.zeus.dao.entity.user.value.ZeusUserType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "zeus_users")
public class ZeusUser {

    public static final String RequestScopeAttributeName="pollen8user";

    @Id
    private UUID id;

    @NotNull
    private String username;
    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ZeusUserType accountType;

    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String skypeName;
    @NotNull
    private String emailAddress;
    @NotNull
    private String contactNumberCellphone;
    private String contactNumberLandline;
    @NotNull
    private String country;
    private String agencyName;
    private String agencyContactNumber;
    private String agencyAddress;

    private String billingMethod;
    private String billingBranchCode;
    private String billingBranch;
    private String billingName;
    private String billingAccountNo;
    private String billingAccountName;

    public static String getRequestScopeAttributeName() {
        return RequestScopeAttributeName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZeusUserType getAccountType() {
        return accountType;
    }

    public void setAccountType(ZeusUserType accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumberCellphone() {
        return contactNumberCellphone;
    }

    public void setContactNumberCellphone(String contactNumberCellphone) {
        this.contactNumberCellphone = contactNumberCellphone;
    }

    public String getContactNumberLandline() {
        return contactNumberLandline;
    }

    public void setContactNumberLandline(String contactNumberLandline) {
        this.contactNumberLandline = contactNumberLandline;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyContactNumber() {
        return agencyContactNumber;
    }

    public void setAgencyContactNumber(String agencyContactNumber) {
        this.agencyContactNumber = agencyContactNumber;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod;
    }

    public String getBillingBranchCode() {
        return billingBranchCode;
    }

    public void setBillingBranchCode(String billingBranchCode) {
        this.billingBranchCode = billingBranchCode;
    }

    public String getBillingBranch() {
        return billingBranch;
    }

    public void setBillingBranch(String billingBranch) {
        this.billingBranch = billingBranch;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingAccountNo() {
        return billingAccountNo;
    }

    public void setBillingAccountNo(String billingAccountNo) {
        this.billingAccountNo = billingAccountNo;
    }

    public String getBillingAccountName() {
        return billingAccountName;
    }

    public void setBillingAccountName(String billingAccountName) {
        this.billingAccountName = billingAccountName;
    }
}
