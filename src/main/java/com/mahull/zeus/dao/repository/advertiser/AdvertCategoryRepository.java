package com.mahull.zeus.dao.repository.advertiser;

import com.mahull.zeus.dao.entity.advertiser.AdvertCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvertCategoryRepository extends JpaRepository<AdvertCategory, UUID> {
}
