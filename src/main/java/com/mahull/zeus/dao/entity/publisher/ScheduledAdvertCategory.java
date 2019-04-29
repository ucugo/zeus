package com.mahull.zeus.dao.entity.publisher;

import com.mahull.zeus.dao.entity.advertiser.AdvertCategory;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Table(name="scheduled_advert_categories")
public class ScheduledAdvertCategory {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @ManyToOne
    @JoinColumn(name="advert_category_id")
    private AdvertCategory advertCategory;

    @Min(0) @Max(23)
    private Integer startAt;
    @Min(0) @Max(23)
    private Integer endAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AdvertCategory getAdvertCategory() {
        return advertCategory;
    }

    public void setAdvertCategory(AdvertCategory advertCategory) {
        this.advertCategory = advertCategory;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getEndAt() {
        return endAt;
    }

    public void setEndAt(Integer endAt) {
        this.endAt = endAt;
    }
}
