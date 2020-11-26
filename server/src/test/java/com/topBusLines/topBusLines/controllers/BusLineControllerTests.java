package com.topBusLines.topBusLines.controllers;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.services.BusService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BusLineControllerTests {
    @Mock
    private BusService busService;

    @InjectMocks
    private BusController sut;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(sut)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }
    @Test
    public void busLines_Should_Return_Expected_Status_Code_200() throws Exception {
        when(busService.getBusLines(anyInt())).thenReturn(new ArrayList());

        mockMvc.perform(get("/buslines?limit=10"))
                .andExpect(status().isOk());
    }

    @Test()
    public void busLines_Should_Return_Expected_Status_Code_400() throws Exception {
        when(busService.getBusLines(anyInt())).thenThrow(new TrafiklabRequestException("test"));

        mockMvc.perform(get("/buslines?limit=100"))
                .andExpect(status().is(400));
    }

    @Test()
    public void busLines_Should_Return_Expected_Status_Code_404() throws Exception {
        when(busService.getBusLines(anyInt())).thenThrow(new NullPointerException("test"));

        mockMvc.perform(get("/buslines?limit=100"))
                .andExpect(status().is(404));
    }

    @Test
    public void busLines_linesOrderedByStops_Should_Have_Been_Called_With_Expected_Value() throws Exception {
        when(busService.getBusLines(anyInt())).thenReturn(new ArrayList());

        mockMvc.perform(get("/buslines?limit=12"))
                .andExpect(status().isOk());

        verify(busService).getBusLines(12);
    }

}