package com.mahull.zeus.domain.advertiser;

import com.mahull.zeus.domain.tracking.TrackingTarget;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advert")
public class Advert {

    @Id
    private UUID id;

    @ManyToOne(optional = false)
    private Campaign campaign;

    @Lob
    @NotNull(message="Default text required, This WILL display on site if banner can not display.")
    private String advertText;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "imageId", column = @Column(name = "banner_image_id")),
            @AttributeOverride(name = "width", column = @Column(name = "banner_width")),
            @AttributeOverride(name = "height", column = @Column(name = "banner_height"))
    })
    private ImageInfo banner = new ImageInfo();

    @Lob
    @NotNull
    @Pattern(regexp = "(https?://.*)|(call:[0-9]+)|(ussd:\\*[0-9]+(\\*[0-9]+)*#)|(sms:[0-9]+\\?body=.*)", message = "must be a valid URL")
    private String url;

    @NotNull
    private String advertName;

    @OneToMany(mappedBy = "advert")
    private List<TrackingTarget> trackingTargets = new ArrayList<TrackingTarget>();

    private boolean paused = false;

    @Enumerated(EnumType.STRING)
    private AdvertMode mode = AdvertMode.INTERNAL;

    @Enumerated(EnumType.STRING)
    private AdvertType type = AdvertType.TEXT;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    private ApprovalState approvalState=ApprovalState.Pending;

    @Transient
    private String disapprovedReason;

    private BigDecimal forceClickThroughRate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date forceClickThroughRateLastReset;

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

    public String getAdvertText() {
        return advertText;
    }

    public void setAdvertText(String advertText) {
        this.advertText = advertText;
    }

    public ImageInfo getBanner() {
        return banner;
    }

    public void setBanner(ImageInfo banner) {
        this.banner = banner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public List<TrackingTarget> getTrackingTargets() {
        return trackingTargets;
    }

    public void setTrackingTargets(List<TrackingTarget> trackingTargets) {
        this.trackingTargets = trackingTargets;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public AdvertMode getMode() {
        return mode;
    }

    public void setMode(AdvertMode mode) {
        this.mode = mode;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ApprovalState getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(ApprovalState approvalState) {
        this.approvalState = approvalState;
    }

    public String getDisapprovedReason() {
        return disapprovedReason;
    }

    public void setDisapprovedReason(String disapprovedReason) {
        this.disapprovedReason = disapprovedReason;
    }

    public BigDecimal getForceClickThroughRate() {
        return forceClickThroughRate;
    }

    public void setForceClickThroughRate(BigDecimal forceClickThroughRate) {
        this.forceClickThroughRate = forceClickThroughRate;
    }

    public Date getForceClickThroughRateLastReset() {
        return forceClickThroughRateLastReset;
    }

    public void setForceClickThroughRateLastReset(Date forceClickThroughRateLastReset) {
        this.forceClickThroughRateLastReset = forceClickThroughRateLastReset;
    }
}
