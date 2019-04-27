package com.mahull.zeus.dao.entity.publisher;

import com.mahull.zeus.dao.entity.placement.Placement;
import com.mahull.zeus.dao.entity.advertiser.value.ApprovalState;
import com.mahull.zeus.dao.entity.publisher.external.ExternalPublisherSite;

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
@Table(name = "publisher_site")
public class PublisherSite {

    @Id
    private UUID id;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isShowsBanners() {
        return showsBanners;
    }

    public void setShowsBanners(boolean showsBanners) {
        this.showsBanners = showsBanners;
    }

    public boolean isShowsText() {
        return showsText;
    }

    public void setShowsText(boolean showsText) {
        this.showsText = showsText;
    }

    public boolean isShowsRichMedia() {
        return showsRichMedia;
    }

    public void setShowsRichMedia(boolean showsRichMedia) {
        this.showsRichMedia = showsRichMedia;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isSendNetCpc() {
        return sendNetCpc;
    }

    public void setSendNetCpc(boolean sendNetCpc) {
        this.sendNetCpc = sendNetCpc;
    }

    public ApprovalState getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(ApprovalState approvalState) {
        this.approvalState = approvalState;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public BigDecimal getRevenueSharePercentage() {
        return revenueSharePercentage;
    }

    public void setRevenueSharePercentage(BigDecimal revenueSharePercentage) {
        this.revenueSharePercentage = revenueSharePercentage;
    }

    public Date getLastRequestReceived() {
        return lastRequestReceived;
    }

    public void setLastRequestReceived(Date lastRequestReceived) {
        this.lastRequestReceived = lastRequestReceived;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public List<ScheduledAdvertCategory> getScheduledAdvertCategories() {
        return scheduledAdvertCategories;
    }

    public void setScheduledAdvertCategories(List<ScheduledAdvertCategory> scheduledAdvertCategories) {
        this.scheduledAdvertCategories = scheduledAdvertCategories;
    }

    public ExternalPublisherSite getExternalPublisherSite() {
        return externalPublisherSite;
    }

    public void setExternalPublisherSite(ExternalPublisherSite externalPublisherSite) {
        this.externalPublisherSite = externalPublisherSite;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }
}
