package com.mahull.zeus.dao.repository.filter;

import com.mahull.zeus.dao.entity.filter.CampaignFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CampaignFilterRepository extends JpaRepository<CampaignFilter, UUID> {
}
