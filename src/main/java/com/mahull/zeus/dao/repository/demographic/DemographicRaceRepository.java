package com.mahull.zeus.dao.repository.demographic;

import com.mahull.zeus.dao.entity.demographic.DemographicRace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemographicRaceRepository extends JpaRepository<DemographicRace, UUID> {
}
