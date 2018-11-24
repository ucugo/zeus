package com.mahull.zeus.repository;

import com.mahull.zeus.domain.location.GeoIPLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeoIpLocationRepository extends JpaRepository<GeoIPLocation, UUID> {
}