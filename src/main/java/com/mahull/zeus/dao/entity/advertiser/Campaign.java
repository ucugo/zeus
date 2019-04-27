package com.mahull.zeus.dao.entity.advertiser;

import com.mahull.zeus.dao.entity.advertiser.value.ApprovalState;
import com.mahull.zeus.dao.entity.placement.Placement;
import com.mahull.zeus.dao.value.RunDays;
import com.mahull.zeus.dao.value.TrackingParameterNames;
import com.mahull.zeus.dao.entity.filter.CampaignFilter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    private UUID id;
    @NotNull
    private String campaignName;
    @NotNull
    @ManyToOne(optional = false)
    private Advertiser advertiser;
    @NotNull
    private String currencyCode;
    @NotNull
    private String timeZone = "GMT+2";
    @Lob
    private String notes;
    private String landingPreferedAcquisitionCodeKey = TrackingParameterNames.CPA_PARAM_NAME;
    private BigDecimal remainingBudget;
    private BigDecimal dailySpendCap;
    private BigDecimal remainingDailySpend;
    private BigDecimal costPerClick;
    private BigDecimal costPerAcquisition;
    private BigDecimal costPerDownload;
    private BigDecimal costPerMille;
    private BigDecimal commissionInternal;
    private BigDecimal commissionExternal;
    private BigDecimal minForceClickThroughRate;
    private BigDecimal maxForceClickThroughRate;
    private Date dailySpendLastReset;
    @Future
    private Date automaticallyPauseAt;
    private Date deletedAt;
    private Date startDate;
    private Date endDate;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<RunDays> runOnDaysOfTheWeek;
    @Min(0)
    @Max(23)
    private Integer startHour;
    @Min(0)
    @Max(23)
    private Integer endHour;

    private boolean paused = true;
    private boolean partner = false;
    private boolean uniqueUserPerClickedAdvertRequired = false;
    private boolean addInternalTrackingToRedirectUrl = true;
    @ManyToOne
    @NotNull
    private AdvertCategory category;
    @Enumerated(EnumType.STRING)
    private ApprovalState approvalState=ApprovalState.Pending;
    @Transient
    private String disapprovedReason;

    @OneToMany(mappedBy = "campaign")
    private List<Advert> adverts = new ArrayList<>();
    @OneToMany(mappedBy = "campaign")
    private List<Placement> placements = new ArrayList<>();
    @OneToOne(fetch=FetchType.EAGER)
    private CampaignFilter campaignFilter=new CampaignFilter();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLandingPreferedAcquisitionCodeKey() {
        return landingPreferedAcquisitionCodeKey;
    }

    public void setLandingPreferedAcquisitionCodeKey(String landingPreferedAcquisitionCodeKey) {
        this.landingPreferedAcquisitionCodeKey = landingPreferedAcquisitionCodeKey;
    }

    public BigDecimal getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(BigDecimal remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public BigDecimal getDailySpendCap() {
        return dailySpendCap;
    }

    public void setDailySpendCap(BigDecimal dailySpendCap) {
        this.dailySpendCap = dailySpendCap;
    }

    public BigDecimal getRemainingDailySpend() {
        return remainingDailySpend;
    }

    public void setRemainingDailySpend(BigDecimal remainingDailySpend) {
        this.remainingDailySpend = remainingDailySpend;
    }

    public BigDecimal getCostPerClick() {
        return costPerClick;
    }

    public void setCostPerClick(BigDecimal costPerClick) {
        this.costPerClick = costPerClick;
    }

    public BigDecimal getCostPerAcquisition() {
        return costPerAcquisition;
    }

    public void setCostPerAcquisition(BigDecimal costPerAcquisition) {
        this.costPerAcquisition = costPerAcquisition;
    }

    public BigDecimal getCostPerDownload() {
        return costPerDownload;
    }

    public void setCostPerDownload(BigDecimal costPerDownload) {
        this.costPerDownload = costPerDownload;
    }

    public BigDecimal getCostPerMille() {
        return costPerMille;
    }

    public void setCostPerMille(BigDecimal costPerMille) {
        this.costPerMille = costPerMille;
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

    public BigDecimal getMinForceClickThroughRate() {
        return minForceClickThroughRate;
    }

    public void setMinForceClickThroughRate(BigDecimal minForceClickThroughRate) {
        this.minForceClickThroughRate = minForceClickThroughRate;
    }

    public BigDecimal getMaxForceClickThroughRate() {
        return maxForceClickThroughRate;
    }

    public void setMaxForceClickThroughRate(BigDecimal maxForceClickThroughRate) {
        this.maxForceClickThroughRate = maxForceClickThroughRate;
    }

    public Date getDailySpendLastReset() {
        return dailySpendLastReset;
    }

    public void setDailySpendLastReset(Date dailySpendLastReset) {
        this.dailySpendLastReset = dailySpendLastReset;
    }

    public Date getAutomaticallyPauseAt() {
        return automaticallyPauseAt;
    }

    public void setAutomaticallyPauseAt(Date automaticallyPauseAt) {
        this.automaticallyPauseAt = automaticallyPauseAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<RunDays> getRunOnDaysOfTheWeek() {
        return runOnDaysOfTheWeek;
    }

    public void setRunOnDaysOfTheWeek(List<RunDays> runOnDaysOfTheWeek) {
        this.runOnDaysOfTheWeek = runOnDaysOfTheWeek;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public boolean isUniqueUserPerClickedAdvertRequired() {
        return uniqueUserPerClickedAdvertRequired;
    }

    public void setUniqueUserPerClickedAdvertRequired(boolean uniqueUserPerClickedAdvertRequired) {
        this.uniqueUserPerClickedAdvertRequired = uniqueUserPerClickedAdvertRequired;
    }

    public boolean isAddInternalTrackingToRedirectUrl() {
        return addInternalTrackingToRedirectUrl;
    }

    public void setAddInternalTrackingToRedirectUrl(boolean addInternalTrackingToRedirectUrl) {
        this.addInternalTrackingToRedirectUrl = addInternalTrackingToRedirectUrl;
    }

    public AdvertCategory getCategory() {
        return category;
    }

    public void setCategory(AdvertCategory category) {
        this.category = category;
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

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public CampaignFilter getCampaignFilter() {
        return campaignFilter;
    }

    public void setCampaignFilter(CampaignFilter campaignFilter) {
        this.campaignFilter = campaignFilter;
    }
}
