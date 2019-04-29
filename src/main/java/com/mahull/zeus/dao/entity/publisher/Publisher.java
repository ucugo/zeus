package com.mahull.zeus.dao.entity.publisher;

import com.mahull.zeus.dao.entity.publisher.external.ExternalPublisher;
import com.mahull.zeus.dao.entity.user.ZeusUser;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZeusUser getPollen8User() {
        return pollen8User;
    }

    public void setPollen8User(ZeusUser pollen8User) {
        this.pollen8User = pollen8User;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List<PublisherSite> getPublisherSites() {
        return publisherSites;
    }

    public void setPublisherSites(List<PublisherSite> publisherSites) {
        this.publisherSites = publisherSites;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ExternalPublisher getExternalPublisher() {
        return externalPublisher;
    }

    public void setExternalPublisher(ExternalPublisher externalPublisher) {
        this.externalPublisher = externalPublisher;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
