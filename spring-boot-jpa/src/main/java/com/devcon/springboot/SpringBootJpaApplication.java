package com.devcon.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.devcon.springboot.domain.Employee;
import com.devcon.springboot.domain.EmployeeRepository;

@SpringBootApplication
public class SpringBootJpaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(EmployeeRepository repository) {
		return args -> {
			repository.save(new Employee("Jel","Maganda"));
			repository.save(new Employee("Justin", "Malakas"));
			
			log.info("Employee found: ");
			log.info("----------------");
			
			for (Employee emp : repository.findAll()) {
				log.info(emp.toString());
			}
		};
	}


}
