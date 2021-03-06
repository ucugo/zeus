package com.mahull.zeus.dao.entity.statistics;

import com.mahull.zeus.dao.entity.tracking.TrackingTarget;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tracking_target_statistics")
public class TrackingTargetStatistics {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @ManyToOne(optional = false)
    private TrackingTarget trackingTarget;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_utc")
    private Date dateUTC;
    @Column(name = "hour_utc", columnDefinition = "TINYINT NOT NULL")
    private int hourUTC;
    @Embedded
    private ObjectStatistics values;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TrackingTarget getTrackingTarget() {
        return trackingTarget;
    }

    public void setTrackingTarget(TrackingTarget trackingTarget) {
        this.trackingTarget = trackingTarget;
    }

    public Date getDateUTC() {
        return dateUTC;
    }

    public void setDateUTC(Date dateUTC) {
        this.dateUTC = dateUTC;
    }

    public int getHourUTC() {
        return hourUTC;
    }

    public void setHourUTC(int hourUTC) {
        this.hourUTC = hourUTC;
    }

    public ObjectStatistics getValues() {
        return values;
    }

    public void setValues(ObjectStatistics values) {
        this.values = values;
    }
}
