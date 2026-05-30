package com.learning.first.repository;

import com.learning.first.modal.PaymentTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTrackRepository extends JpaRepository<PaymentTrack, Integer> {
    // Keep this empty! Spring will auto-generate all CRUD operations.
}