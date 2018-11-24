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
    private static final long serialVersionUID = 8907688169701130000L;
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

}
