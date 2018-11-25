package com.mahull.zeus.domain.placement;

import com.mahull.zeus.domain.advertiser.Campaign;
import com.mahull.zeus.domain.publisher.PublisherSite;
import com.mahull.zeus.domain.statistics.ObjectStatistics;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "placement")
public class Placement {

    private static final long serialVersionUID = 7753325031172223735L;
    public static int MAX_WEIGHT = 100;
    public static int MIN_WEIGHT = 1;

    @Id
    private UUID id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Campaign campaign;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PublisherSite publisherSite;
    private int weight = 10;
    @Min(0) @Max(100)
    private BigDecimal revShareOverride;
    @Transient
    private ObjectStatistics currentStatistics;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static int getMaxWeight() {
        return MAX_WEIGHT;
    }

    public static void setMaxWeight(int maxWeight) {
        MAX_WEIGHT = maxWeight;
    }

    public static int getMinWeight() {
        return MIN_WEIGHT;
    }

    public static void setMinWeight(int minWeight) {
        MIN_WEIGHT = minWeight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public PublisherSite getPublisherSite() {
        return publisherSite;
    }

    public void setPublisherSite(PublisherSite publisherSite) {
        this.publisherSite = publisherSite;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BigDecimal getRevShareOverride() {
        return revShareOverride;
    }

    public void setRevShareOverride(BigDecimal revShareOverride) {
        this.revShareOverride = revShareOverride;
    }

    public ObjectStatistics getCurrentStatistics() {
        return currentStatistics;
    }

    public void setCurrentStatistics(ObjectStatistics currentStatistics) {
        this.currentStatistics = currentStatistics;
    }
}
