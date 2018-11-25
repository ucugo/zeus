package com.mahull.zeus.domain.location;

import javax.persistence.*;
import java.net.InetAddress;
import java.util.TimeZone;
import java.util.UUID;

@Entity
@Table(name="geo_ip_location")
public class GeoIPLocation {

    public static final String ALL_CITIES = "**ALL**";

    @Id
    private UUID id;
    private String countryCode;
    private String countryName;
    private String network;
    private String region;
    private String city;
    private TimeZone timeZone;
    private boolean proxy;
    @Transient
    private long loadTime;
    @Transient private long fetchTime;
    @Transient private long lastCalledTime;
    @Transient private String ipAddress;
    @Transient private InetAddress address;
    @Transient private String xForwardedAddress;
    @Transient private String debugNetworkFromDatabase;
    @Transient private String debugLocationFromDatabase;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isProxy() {
        return proxy;
    }

    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public long getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(long fetchTime) {
        this.fetchTime = fetchTime;
    }

    public long getLastCalledTime() {
        return lastCalledTime;
    }

    public void setLastCalledTime(long lastCalledTime) {
        this.lastCalledTime = lastCalledTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public String getxForwardedAddress() {
        return xForwardedAddress;
    }

    public void setxForwardedAddress(String xForwardedAddress) {
        this.xForwardedAddress = xForwardedAddress;
    }

    public String getDebugNetworkFromDatabase() {
        return debugNetworkFromDatabase;
    }

    public void setDebugNetworkFromDatabase(String debugNetworkFromDatabase) {
        this.debugNetworkFromDatabase = debugNetworkFromDatabase;
    }

    public String getDebugLocationFromDatabase() {
        return debugLocationFromDatabase;
    }

    public void setDebugLocationFromDatabase(String debugLocationFromDatabase) {
        this.debugLocationFromDatabase = debugLocationFromDatabase;
    }
}
