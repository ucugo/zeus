package com.mahull.zeus.dao.entity.publisher.external;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ExternalPublisherSite {

    @Id
    private UUID id;

    @ManyToOne
    private ExternalPublisher externalPublisher;
    @NotNull
    private BigDecimal dailySpendCap= new BigDecimal(2500f);
    @Lob
    private String countryAndNetworks;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ExternalPublisher getExternalPublisher() {
        return externalPublisher;
    }

    public void setExternalPublisher(ExternalPublisher externalPublisher) {
        this.externalPublisher = externalPublisher;
    }

    public BigDecimal getDailySpendCap() {
        return dailySpendCap;
    }

    public void setDailySpendCap(BigDecimal dailySpendCap) {
        this.dailySpendCap = dailySpendCap;
    }

    public String getCountryAndNetworks() {
        return countryAndNetworks;
    }

    public void setCountryAndNetworks(String countryAndNetworks) {
        this.countryAndNetworks = countryAndNetworks;
    }
}
