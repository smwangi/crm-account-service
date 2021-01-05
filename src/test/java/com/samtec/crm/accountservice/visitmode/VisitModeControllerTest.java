package com.samtec.crm.accountservice.visitmode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samtec.crm.accountservice.ApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.mockito.Mockito;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = VisitModeController.class)
@AutoConfigureMockMvc
public class VisitModeControllerTest extends ApplicationTests {

    @InjectMocks
    VisitModeController visitModeController;

    @MockBean
    VisitModeService visitModeService;

    @Autowired
    MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFetchAll() throws URISyntaxException{
        /*RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8086/api/v1/visitmode";
        URI uri = new URI(baseUrl);

        HttpEntity<List<VisitModeDto>> requestEntity = new HttpEntity<>(null,null);
        ResponseEntity<?> result = restTemplate.getForEntity(uri,List.class);*/
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        VisitModeDto visitModeDto = new VisitModeDto();
        visitModeDto.setName("Walk in");
        var visitMode2 = new VisitModeDto();
        visitMode2.setName("Phone call");

        List<VisitModeDto> visitModeDtoList = List.of(visitModeDto,visitMode2);

        when(visitModeService.fetchAll()).thenReturn(visitModeDtoList);

        //When
        List<VisitModeDto> list = visitModeController.fetchAll();

        //then
        assertTrue(list.size() > 0);
    }

    @Test
    void testFindById() throws Exception{
        Long id = 1l;
        VisitModeDto dto = new VisitModeDto();
        dto.setName("Walk in");
        dto.setId(1l);

        given(visitModeService.findById(id)).willReturn(Optional.of(dto));

        mockMvc.perform(get("/api/v1/visitmodes/1")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        //.andExpect(jsonPath("$",hasSize(0)))

        ;
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/visitmodes/test",
                String.class)).contains("Hello, World");
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception{
        mockMvc.perform(get("/api/v1/visitmodes/test").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void testCreateVisitMode() throws Exception{
        VisitModeDto dto = new VisitModeDto();
        dto.setName("Waba_"+new Random().nextInt());
        dto.setDescription("Waba Desc");
        mockMvc.perform(post("/api/v1/visitmodes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
        .andExpect(status().isOk());
    }
}
