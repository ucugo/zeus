package com.mahull.zeus.dao.repository.publisher;

import com.mahull.zeus.dao.entity.publisher.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
