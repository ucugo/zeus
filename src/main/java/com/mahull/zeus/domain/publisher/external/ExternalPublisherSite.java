package com.mahull.zeus.domain.publisher.external;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ExternalPublisherSite {

    private static final long serialVersionUID = 8672354332606362381L;

    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    private ExternalPublisher externalPublisher;
    @NotNull
    private BigDecimal dailySpendCap= new BigDecimal(2500f);
    @Lob
    private String countryAndNetworks;
}
