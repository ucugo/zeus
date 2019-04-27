package com.mahull.zeus.dao.entity.device;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="handset")
public class Handset {

    public static final String ALL = "all";

    @Id
    private UUID id;
    private String sourceId;
    private String brandName;
    private String modelName;
    private String marketingName;
    private String os;
    private String version;
    @Transient
    private String browserName;
    @Transient private String browserVersion;
    @Transient private String makePhoneCallString;
    @Transient private String makePhoneSmsString;
    @Transient private boolean wirelessDevice;
    @Transient private boolean tablet;
    @Transient private boolean canAssignPhoneNumber;
    @Transient private boolean wifi;
    @Transient private long loadTime;
    @Transient private long fetchTime;
    @Transient private long lastCalledTime;
    @Transient private String userAgent;

    public String getSourceId() {
        return sourceId;
    }
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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
    public long getLoadTime() {
        return loadTime;
    }
    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }
    public long getLastCalledTime() {
        return lastCalledTime;
    }
    public void setLastCalledTime(long lastCalledTime) {
        this.lastCalledTime = lastCalledTime;
    }
    public void called() {
        setLastCalledTime(System.currentTimeMillis());
    }
    public String getUserAgent() {
        return userAgent;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getMarketingName() {
        return marketingName;
    }
    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
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
    public boolean isWifi() {
        return wifi;
    }
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
    public boolean isCanAssignPhoneNumber() {
        return canAssignPhoneNumber;
    }
    public void setCanAssignPhoneNumber(boolean canAssignPhoneNumber) {
        this.canAssignPhoneNumber = canAssignPhoneNumber;
    }
    public boolean isTablet() {
        return tablet;
    }
    public void setTablet(boolean tablet) {
        this.tablet = tablet;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
