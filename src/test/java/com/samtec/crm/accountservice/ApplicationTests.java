package com.samtec.crm.accountservice;

import com.samtec.crm.accountservice.visitmode.VisitModeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {Application.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Autowired
	private VisitModeRepository visitModeRepository;

	@Test
	void contextLoads() throws Exception {
		assertThat(visitModeRepository).isNotNull();
	}

}
