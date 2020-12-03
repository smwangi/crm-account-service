package com.samtec.crm.accountservice.visitmode;

import com.samtec.crm.accountservice.ApplicationTests;
import com.samtec.crm.accountservice.visit.VisitDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class VisitModeServiceTest extends ApplicationTests {

    @Autowired
    private VisitModeService visitModeService;

    @Autowired
    private VisitModeMapper mapper;

    @Autowired
    private VisitModeRepository visitModeRepository;

    @Test
    @DisplayName("Visit Mode Find By Id")
    void testFindById(){

        Optional<VisitModeDto> returnDto = visitModeService.findById(1l);

        assertTrue(returnDto.isPresent(),"Visit Mode was not found");
        assertNotNull(returnDto.get());
        System.out.println("VISIT_MODE_ID: "+returnDto.get().getId()+"_"+Integer.valueOf("1"));
        assertEquals(returnDto.get().getId(),Long.valueOf("1"));
    }
    @Test
    void testSaveVisitMode(){
        VisitModeDto visitModeDto = new VisitModeDto();
        visitModeDto.setName("Tests_"+ new Random().ints());
        visitModeDto.setDescription("Testing");


        VisitModeDto visitModeDto1 = visitModeService.save(visitModeDto);
        assertEquals(visitModeDto.getName(),visitModeDto1.getName());
    }
    @Test
    void testFetchAll(){
        VisitModeDto visitModeDto = new VisitModeDto();
        visitModeDto.setName("Tests_"+ new Random().nextInt());
        visitModeDto.setDescription("Testing");
        visitModeService.save(visitModeDto);
        List<VisitModeDto> visitDtoList = visitModeService.fetchAll();
        assertTrue(visitDtoList.size() > 0);
    }
    @Test
    void testUpdate(){
       VisitModeDto visitModeDto = visitModeService.findById(3l).get();
        //if(visitModeDto.isPresent()){
            //var viv = visitModeDto.get();
        System.out.println("VISITMODE_ID: "+visitModeDto.getId());
            visitModeDto.setName("My Visit Mode");
            visitModeDto.setModifiedAt(LocalDateTime.now());
            VisitModeDto visitModeDto1 = visitModeService.save(visitModeDto);
            assertEquals(visitModeDto1.getName(),visitModeDto.getName());
       // }
    }
}
