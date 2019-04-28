package com.mahull.zeus.dao.repository.device;

import com.mahull.zeus.dao.entity.device.Handset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HandsetRepository extends JpaRepository<Handset, UUID> {
}
