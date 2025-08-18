package com.example.driver_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.driver_service.model.Driver;
import com.example.driver_service.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver saveDriver(Driver driver) {
        if (driverRepository.existsByLicenseNumber(driver.getLicenseNumber())) {
            throw new RuntimeException("License number already exists");
        }
        if (driverRepository.existsByEmail(driver.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver updateDriver(Long id, Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setLicenseNumber(updatedDriver.getLicenseNumber());
            driver.setPhoneNumber(updatedDriver.getPhoneNumber());

            
            if (updatedDriver.getEmail() != null) {
                driver.setEmail(updatedDriver.getEmail());
            }

            driver.setAvailabilityStatus(updatedDriver.getAvailabilityStatus());
            driver.setVehicleId(updatedDriver.getVehicleId());

            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
