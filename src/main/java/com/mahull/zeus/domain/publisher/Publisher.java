package com.mahull.zeus.domain.publisher;

import com.mahull.zeus.domain.publisher.external.ExternalPublisher;
import com.mahull.zeus.domain.user.ZeusUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "publishers")
public class Publisher {

    private static final long serialVersionUID = -925308376431000316L;
    @Id
    @GeneratedValue
    private UUID uuid;
    @ManyToOne(optional = false)
    private ZeusUser pollen8User;
    @NotNull
    private String publisherName;
    @OneToMany(mappedBy = "publisher")
    private List<PublisherSite> publisherSites;
    @NotNull
    private String contactNumber;
    @NotNull
    private String contactEmail;
    @Lob
    private String notes;
    @ManyToOne
    private ExternalPublisher externalPublisher = null;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
}
