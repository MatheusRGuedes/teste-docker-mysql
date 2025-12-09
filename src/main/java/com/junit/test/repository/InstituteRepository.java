package com.junit.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junit.test.model.Institute;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {

}
