package edu.sf.ebolt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.sf.springmvc", "edu.sf.ebolt" })
@EnableConfigurationProperties
public class EboltApplication {

	public static void main(String[] args) {
		SpringApplication.run(EboltApplication.class, args);
	}

}
