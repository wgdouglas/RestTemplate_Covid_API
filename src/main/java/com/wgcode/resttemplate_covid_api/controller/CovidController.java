package com.wgcode.resttemplate_covid_api.controller;

import com.wgcode.resttemplate_covid_api.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/covid")
public class CovidController {


    private final CovidService covidService;

    @GetMapping("/get-all-country-covid-data")
    public ResponseEntity<?> callRapidEndpointToGetCovidFata(){
        return ResponseEntity.ok(covidService.getALLCountryCovidData());
    }
}
