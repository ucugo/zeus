package com.mahull.zeus.dao.repository.device;

import com.mahull.zeus.dao.entity.device.HandsetGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HandsetGroupRepository extends JpaRepository<HandsetGroup, UUID> {
}
