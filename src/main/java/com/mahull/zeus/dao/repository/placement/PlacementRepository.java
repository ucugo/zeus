package com.mahull.zeus.dao.repository.placement;

import com.mahull.zeus.dao.entity.placement.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, UUID> {
}
