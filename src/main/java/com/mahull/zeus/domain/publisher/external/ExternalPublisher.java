package com.mahull.zeus.domain.publisher.external;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class ExternalPublisher {

    private static final long serialVersionUID = 635626502880486855L;

    @Id
    @GeneratedValue
    private UUID uuid;

    @NotNull
    private String name;
    @NotNull
    private String moduleName;

    @Lob
    private String countryAndNetworksOptions;
    @Lob
    private String countryAndNetworksDefault;
    @Lob
    private String accounts;

    private BigDecimal dailyCapDefault;

}
