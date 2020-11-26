package com.topBusLines.topBusLines.controllers;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.models.BusLine;
import com.topBusLines.topBusLines.services.IBusService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BusController {
    private IBusService busService;

    public BusController(IBusService busService) {
        this.busService = busService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/buslines", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusLine> busLines(@RequestParam(value = "limit", defaultValue = "1") int limit, final HttpServletResponse response) throws TrafiklabRequestException {
        response.addHeader("Cache-Control", "max-age=86400, must-revalidate, no-transform");
        return busService.getBusLines(limit);
    }
}
