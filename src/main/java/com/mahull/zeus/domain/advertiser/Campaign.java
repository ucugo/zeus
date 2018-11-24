package com.mahull.zeus.domain.advertiser;

import com.mahull.zeus.domain.placement.Placement;
import com.mahull.zeus.domain.RunDays;
import com.mahull.zeus.domain.TrackingParameterNames;
import com.mahull.zeus.domain.filter.CampaignFilter;

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
@Table(name = "campaigns")
public class Campaign {

    private static final long serialVersionUID = -8150226601971196894L;

    @Id
    @GeneratedValue
    private UUID uuid;
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

//    @ElementCollection
//    @Enumerated(EnumType.STRING)
//    private List<RunDays> runOnDaysOfTheWeek;
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
}
