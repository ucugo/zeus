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
@Table(name = "adverts")
public class Advert {

    private static final long serialVersionUID = 822402511466963439L;

    @Id
    @GeneratedValue
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
}
