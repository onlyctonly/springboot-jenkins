package com.example.beer;

import com.example.beer.controller.BeerController;
import com.example.beer.dto.BeerDTO;
import com.example.beer.service.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerService service;

    @Test
    public void getBeer() throws Exception {
        when(service.getBeerById(UUID.fromString("1fd1e0f1-3202-45ca-88aa-921eee530601")))
                .thenReturn(BeerDTO.builder().beerName("hellobeer").build());
        this.mockMvc.perform(get("/api/v1/beer/1fd1e0f1-3202-45ca-88aa-921eee530601")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hellobeer")));
    }
}
