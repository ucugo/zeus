package com.mahull.zeus.dao.repository.location;

import com.mahull.zeus.dao.entity.location.GeoIPLocationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeoIpLocationGroupRepository extends JpaRepository<GeoIPLocationGroup, UUID> {
}
