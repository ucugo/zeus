package com.mahull.zeus.domain.publisher;

import com.mahull.zeus.domain.placement.Placement;
import com.mahull.zeus.domain.advertiser.ApprovalState;
import com.mahull.zeus.domain.publisher.external.ExternalPublisherSite;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "publisher_sites")
public class PublisherSite {

    private static final long serialVersionUID = -3284344462003669340L;

    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @NotNull
    private Publisher publisher;
    @NotNull
    private String siteName;
    @Lob
    private String notes;
    @Lob
    @NotNull
    @Pattern(regexp = "https?://.*", message = "must be a valid URL")
    private String url;
    private boolean showsBanners = true;
    private boolean showsText = true;
    private boolean showsRichMedia = false;
    private boolean paused = false;
    private boolean sendNetCpc = false;
    @Enumerated(EnumType.STRING)
    private ApprovalState approvalState=ApprovalState.Pending;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @Min(0) @Max(100)
    private BigDecimal revenueSharePercentage = new BigDecimal(60);
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRequestReceived;
    @OneToMany(mappedBy = "publisherSite")
    @OrderBy(value = "weight DESC")
    private List<Placement> placements = new ArrayList<Placement>();
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "publisher_sites_scheduled_advert_categories",
            joinColumns = @JoinColumn(name = "publisher_site_id",unique=true),
            inverseJoinColumns = @JoinColumn(name = "scheduled_advert_category_id",unique=true))
    private List<ScheduledAdvertCategory> scheduledAdvertCategories = new ArrayList<ScheduledAdvertCategory>();
    @ManyToOne
    private ExternalPublisherSite externalPublisherSite = null;
    @Transient
    private String rejectedReason;
}
