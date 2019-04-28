package com.mahull.zeus.dao.repository;

import com.mahull.zeus.dao.entity.statistics.TrackingTargetStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrackingTargetStatisticsRepository extends JpaRepository<TrackingTargetStatistics, UUID> {
}
