package com.mahull.zeus.domain.statistics;

import com.mahull.zeus.domain.util.CurrencyUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@Embeddable
public class ObjectStatistics {

    private long clicks = 0L;
    private long acquisitions = 0L;
    private long downloads = 0L;
    @Column(name = "impressions", scale = CurrencyUtils.SCALE, precision = CurrencyUtils.SIZE)
    @NotNull
    private BigDecimal impressions = CurrencyUtils.ZERO;
    private long realImpressions = 0L;
    @Transient
    private long requests = 0L;
    @Column(name = "spend", scale = CurrencyUtils.SCALE, precision = CurrencyUtils.SIZE)
    @NotNull
    private BigDecimal spend = CurrencyUtils.ZERO;
    @Column(name = "commissionInternal", scale = CurrencyUtils.SCALE, precision = CurrencyUtils.SIZE)
    @NotNull
    private BigDecimal commissionInternal = CurrencyUtils.ZERO;
    @Column(name = "commissionExternal", scale = CurrencyUtils.SCALE, precision = CurrencyUtils.SIZE)
    @NotNull
    private BigDecimal commissionExternal = CurrencyUtils.ZERO;
    @Column(name = "publisher_revenue", scale = CurrencyUtils.SCALE, precision = CurrencyUtils.SIZE)
    @NotNull
    private BigDecimal publisherRevenue = CurrencyUtils.ZERO;
    @Transient
    private BigDecimal exchangeRate=null;
    @Transient
    private final Map<String, Object> keyColumns = new LinkedHashMap<String, Object>();

    public long getClicks() {
        return clicks;
    }

    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public long getAcquisitions() {
        return acquisitions;
    }

    public void setAcquisitions(long acquisitions) {
        this.acquisitions = acquisitions;
    }

    public long getDownloads() {
        return downloads;
    }

    public void setDownloads(long downloads) {
        this.downloads = downloads;
    }

    public BigDecimal getImpressions() {
        return impressions;
    }

    public void setImpressions(BigDecimal impressions) {
        this.impressions = impressions;
    }

    public long getRealImpressions() {
        return realImpressions;
    }

    public void setRealImpressions(long realImpressions) {
        this.realImpressions = realImpressions;
    }

    public long getRequests() {
        return requests;
    }

    public void setRequests(long requests) {
        this.requests = requests;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public BigDecimal getCommissionInternal() {
        return commissionInternal;
    }

    public void setCommissionInternal(BigDecimal commissionInternal) {
        this.commissionInternal = commissionInternal;
    }

    public BigDecimal getCommissionExternal() {
        return commissionExternal;
    }

    public void setCommissionExternal(BigDecimal commissionExternal) {
        this.commissionExternal = commissionExternal;
    }

    public BigDecimal getPublisherRevenue() {
        return publisherRevenue;
    }

    public void setPublisherRevenue(BigDecimal publisherRevenue) {
        this.publisherRevenue = publisherRevenue;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Map<String, Object> getKeyColumns() {
        return keyColumns;
    }
}
