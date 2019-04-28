package com.mahull.zeus.dao.repository.device;

import com.mahull.zeus.dao.entity.device.HandsetDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HandsetDetailRepository extends JpaRepository<HandsetDetail, UUID> {
}
