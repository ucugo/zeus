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
@Table(name = "tracking_target")
public class TrackingTarget {

    @Id
    private UUID id;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public PublisherSite getPublisherSite() {
        return publisherSite;
    }

    public void setPublisherSite(PublisherSite publisherSite) {
        this.publisherSite = publisherSite;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public List<TrackingTargetStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<TrackingTargetStatistics> statistics) {
        this.statistics = statistics;
    }

    public BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public DisplayabilityResult getDisplayability() {
        return displayability;
    }

    public void setDisplayability(DisplayabilityResult displayability) {
        this.displayability = displayability;
    }
}
