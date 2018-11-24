package com.mahull.zeus.domain.tracking;

import com.mahull.zeus.domain.placement.Placement;
import com.mahull.zeus.domain.advertiser.Advert;
import com.mahull.zeus.domain.advertiser.DisplayabilityResult;
import com.mahull.zeus.domain.publisher.PublisherSite;
import com.mahull.zeus.domain.statistics.TrackingTargetStatistics;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class TrackingTarget {

    private static final long serialVersionUID = -5318503782646292099L;

    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Advert advert;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private PublisherSite publisherSite;

    //@ManyToOne(fetch = FetchType.EAGER)
    @Transient
    private Placement placement;

    @OneToMany(mappedBy = "trackingTarget")
    private List<TrackingTargetStatistics> statistics;
    @Null
    private BigDecimal priority = null;
    @Transient
    private Double power;

    @Transient
    private Double currentWeight;

    @Transient
    private DisplayabilityResult displayability;
}
