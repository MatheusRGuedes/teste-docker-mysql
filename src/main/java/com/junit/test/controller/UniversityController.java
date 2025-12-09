package com.junit.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.test.model.University;
import com.junit.test.service.UniversityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	private UniversityService service;
	
	@GetMapping
	public ResponseEntity<List<University>> findAll() {
		List<University> universitylist = service.findAll();
		return ResponseEntity.ok(universitylist);
	}
	
	@GetMapping("/{universityId}")
	public ResponseEntity<University> findOne(@PathVariable Long universityId) {
		University universitylist = service.findOne(universityId);
		return ResponseEntity.ok(universitylist);
	}
	
	@PostMapping
	public ResponseEntity<University> create(@RequestBody University request) {
		University university = service.createUniversity(request);
		return ResponseEntity.ok(university);
	}
	
	@PutMapping("/{universityId}")
	public ResponseEntity<University> update(@PathVariable Long universityId, 
			@Valid @RequestBody University request) {
		University university = service.updateUniversity(universityId, request);
		return ResponseEntity.ok(university);
	}
	
	@DeleteMapping("/{universityId}")
	public ResponseEntity<Void> delete(@PathVariable Long universityId) {
		service.deleteUniversity(universityId);
		return ResponseEntity.ok().build();
	}
}
