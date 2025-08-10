package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.FrequentFlyer;
import com.repository.FrequentFlyerRepository;

@Service
public class FrequentFlyerService {
	
	@Autowired
	FrequentFlyerRepository frequentFlyerRepository;
	
	public FrequentFlyer saveFrequentFlyer(FrequentFlyer frequentFlyer) {
		return frequentFlyerRepository.save(frequentFlyer);
	}
	
	public FrequentFlyer viewFrequentFlyer(long id) {
		FrequentFlyer exist = frequentFlyerRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
