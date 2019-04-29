package com.mahull.zeus.dao.entity.publisher.external;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ExternalPublisher {

    private static final long serialVersionUID = 635626502880486855L;

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @NotNull
    private String name;
    @NotNull
    private String moduleName;

    @Lob
    private String countryAndNetworksOptions;
    @Lob
    private String countryAndNetworksDefault;
    @Lob
    private String accounts;

    private BigDecimal dailyCapDefault;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCountryAndNetworksOptions() {
        return countryAndNetworksOptions;
    }

    public void setCountryAndNetworksOptions(String countryAndNetworksOptions) {
        this.countryAndNetworksOptions = countryAndNetworksOptions;
    }

    public String getCountryAndNetworksDefault() {
        return countryAndNetworksDefault;
    }

    public void setCountryAndNetworksDefault(String countryAndNetworksDefault) {
        this.countryAndNetworksDefault = countryAndNetworksDefault;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public BigDecimal getDailyCapDefault() {
        return dailyCapDefault;
    }

    public void setDailyCapDefault(BigDecimal dailyCapDefault) {
        this.dailyCapDefault = dailyCapDefault;
    }
}
