package com.mahull.zeus.domain.publisher;

import com.mahull.zeus.domain.advertiser.AdvertCategory;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Entity
@Table(name="scheduled_advert_categories")
public class ScheduledAdvertCategory {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name="advert_category_id")
    private AdvertCategory advertCategory;

    @Min(0) @Max(23)
    private Integer startAt;
    @Min(0) @Max(23)
    private Integer endAt;
}
