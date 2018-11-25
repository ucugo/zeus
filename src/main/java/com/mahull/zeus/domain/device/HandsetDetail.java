package com.mahull.zeus.domain.device;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="handset_detail")
public class HandsetDetail {

    @Id
    private UUID id;
    private String sourceId;
    private String userAgent;
    private String brandName;
    private String modelName;
    private String marketingName;
    private String os;
    private String version;
    private String browserName;
    private String browserVersion;
    private String makePhoneCallString;
    private String makePhoneSmsString;
    private boolean wirelessDevice;
    private boolean tablet;
    private boolean canAssignPhoneNumber;
    private boolean wifi;
    public String getSourceId() {
        return sourceId;
    }
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    public String getUserAgent() {
        return userAgent;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getMarketingName() {
        return marketingName;
    }
    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getBrowserName() {
        return browserName;
    }
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
    public String getBrowserVersion() {
        return browserVersion;
    }
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
    public String getMakePhoneCallString() {
        return makePhoneCallString;
    }
    public void setMakePhoneCallString(String makePhoneCallString) {
        this.makePhoneCallString = makePhoneCallString;
    }
    public String getMakePhoneSmsString() {
        return makePhoneSmsString;
    }
    public void setMakePhoneSmsString(String makePhoneSmsString) {
        this.makePhoneSmsString = makePhoneSmsString;
    }
    public boolean isWirelessDevice() {
        return wirelessDevice;
    }
    public void setWirelessDevice(boolean wirelessDevice) {
        this.wirelessDevice = wirelessDevice;
    }
    public boolean isTablet() {
        return tablet;
    }
    public void setTablet(boolean tablet) {
        this.tablet = tablet;
    }
    public boolean isCanAssignPhoneNumber() {
        return canAssignPhoneNumber;
    }
    public void setCanAssignPhoneNumber(boolean canAssignPhoneNumber) {
        this.canAssignPhoneNumber = canAssignPhoneNumber;
    }
    public boolean isWifi() {
        return wifi;
    }
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
