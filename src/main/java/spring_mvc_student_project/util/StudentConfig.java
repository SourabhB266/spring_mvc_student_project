package spring_mvc_student_project.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"spring_mvc_student_project"})
public class StudentConfig {

	@Bean
	@Scope(value = "prototype")
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sourabh").createEntityManager();
	}
	
}
