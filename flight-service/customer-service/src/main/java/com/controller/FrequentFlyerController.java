package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.FrequentFlyer;
import com.service.FrequentFlyerService;

@RestController
@RequestMapping("/frequentflyer")
public class FrequentFlyerController {
	
	@Autowired
	FrequentFlyerService frequentFlyerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addFrequentFlyer(@RequestBody FrequentFlyer frequentFlyer){
		return new ResponseEntity<> (frequentFlyerService.saveFrequentFlyer(frequentFlyer), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewFrequentFlyer(@PathVariable long id){
		return new ResponseEntity<> (frequentFlyerService.viewFrequentFlyer(id), HttpStatus.OK);
	}

}
