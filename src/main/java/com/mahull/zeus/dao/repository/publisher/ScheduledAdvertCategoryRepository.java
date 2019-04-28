package com.mahull.zeus.dao.repository.publisher;

import com.mahull.zeus.dao.entity.publisher.ScheduledAdvertCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduledAdvertCategoryRepository extends JpaRepository<ScheduledAdvertCategory, UUID> {
}
