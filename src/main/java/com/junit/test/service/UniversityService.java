package com.junit.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.test.model.University;
import com.junit.test.repository.InstituteRepository;
import com.junit.test.repository.UniversityRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class UniversityService {

	@Autowired
	private UniversityRepository repository;
	@Autowired
	private InstituteRepository instituteRepository; 
	
	public List<University> findAll() {
		return repository.findAll();
	}
	
	public University findOne(Long universityId) {
		University universityFound = repository.findById(universityId)
				.orElseThrow(() -> new RuntimeException("University not found"));
		return universityFound;
	}
	
	public University createUniversity(University university) {
		return repository.save(university);
	}
	
	@Transactional
	public void removeUniversity(University university) {
		University universityFound = repository.findById(university.getId())
				.orElseThrow(() -> new RuntimeException("University not found"));
		
		universityFound.getInstitutes().stream().forEach(institute -> institute.setUniversity(null));
		
		instituteRepository.saveAll(universityFound.getInstitutes());
		
		repository.delete(university);
	} 

	public University updateUniversity(Long universityId, University request) {
		University universityFound = repository.findById(universityId)
				.orElseThrow(() -> new RuntimeException("University not found"));
		
		request.setId(universityId);
		
		return repository.save(request);
	}

	public void deleteUniversity(Long universityId) {
		University universityFound = repository.findById(universityId)
				.orElseThrow(() -> new RuntimeException("University not found"));
		repository.deleteById(universityId);
	}
	 
}
