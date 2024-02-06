package com.b2bsaasapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author sravanrao
 *
 */

@ComponentScan
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.b2bsaasapp.repository")
@EntityScan(basePackages = {"com.b2bsaasapp.domain"})
@SpringBootApplication(scanBasePackages = "com.b2bsaasapp")
public class B2bSaasSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2bSaasSsoApplication.class, args);
	}

}
