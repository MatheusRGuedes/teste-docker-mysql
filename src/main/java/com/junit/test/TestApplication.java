package com.junit.test;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import com.junit.test.model.Institute;
import com.junit.test.model.University;
import com.junit.test.repository.InstituteRepository;
import com.junit.test.repository.UniversityRepository;
import com.junit.test.service.UniversityService;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.junit.test.repository") // Optional, if needed
public class TestApplication implements CommandLineRunner {

	@Autowired
	private UniversityRepository repository;
	
	@Autowired
	private UniversityService service;
	
	@Autowired
	private InstituteRepository instituteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		University univ1 = new University(null, "UVA", "Universidade Veiga de Almeida", null);		
		repository.save(univ1);
		
		Institute institute = new Institute(null, "Tecnico", "Senac", univ1, null);				
		instituteRepository.save(institute);
		
		Institute institute2 = new Institute(null, "IBPS", "Instituto Brasileiros de Psicologia da Saúde", univ1, null);		
		instituteRepository.save(institute2);
		
//		Course course = new Course(null, 10L, institute2);
		
		service.removeUniversity(univ1);
	}
}
