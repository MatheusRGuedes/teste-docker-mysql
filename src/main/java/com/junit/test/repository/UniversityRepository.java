package com.junit.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junit.test.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>{

}
