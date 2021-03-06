package com.mahull.zeus.dao.repository.advertiser;

import com.mahull.zeus.dao.entity.advertiser.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, UUID> {
}
