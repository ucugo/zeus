package com.mahull.zeus.dao.repository.publisher;

import com.mahull.zeus.dao.entity.publisher.PublisherSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherSiteRepository extends JpaRepository<PublisherSite, UUID> {
}
