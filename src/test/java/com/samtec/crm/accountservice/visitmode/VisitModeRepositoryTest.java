package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.Application;
import com.samtec.crm.accountservice.ApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DisplayName("Visit Mode Repository Test")
public class VisitModeRepositoryTest extends ApplicationTests {
    private static final String MOCK_OUTPUT = "Mocked Show Label";
    private static final Logger log = LoggerFactory.getLogger(VisitModeRepositoryTest.class);

    @Autowired
    private VisitModeRepository visitModeRepository;

    @BeforeEach
    void setMockOutput(){
        //when(visitModeRepository.findAll()).thenReturn(MOCK_OUTPUT);
    }

    @Test
    @DisplayName("Test Visit Mode Fetch All")
    public void fetchAllTest(){
        List<VisitMode> visitModeList = visitModeRepository.findAll();
        log.info("Visit Mode List Size: "+visitModeList.size());
        assertTrue(visitModeList.size() > 0);
    }
}
