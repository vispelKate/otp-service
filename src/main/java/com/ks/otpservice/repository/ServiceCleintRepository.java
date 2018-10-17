package com.ks.otpservice.repository;

import com.ks.otpservice.model.ServiceClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCleintRepository extends JpaRepository<ServiceClient,
        Long> {
}
