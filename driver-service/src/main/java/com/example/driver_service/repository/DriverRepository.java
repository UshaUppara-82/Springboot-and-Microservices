package com.example.driver_service.repository;

import com.example.driver_service.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByEmail(String email);
}
