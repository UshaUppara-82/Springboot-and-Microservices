package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.FrequentFlyer;

@Repository
public interface FrequentFlyerRepository extends JpaRepository<FrequentFlyer, Long>{

}
