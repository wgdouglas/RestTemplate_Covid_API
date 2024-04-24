package com.wgcode.resttemplate_covid_api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class CovidService {

    private static final String baseUrl = "https://covid-19-tracking.p.rapidapi.com/v1";
    private static final String xRapidApiKey = "56c7a3ca80msh4d6d16fd3d9ee48p100360jsn9b99379bd404";
    private static final String xRapidApiHost = "covid-19-tracking.p.rapidapi.com";


    @Autowired
    private RestTemplate restTemplate;

    public Object getALLCountryCovidData() {
       try {
           HttpHeaders headers = new HttpHeaders();

           //Headers values are set
           headers.set("X-RapidAPI-Key", xRapidApiKey);
           headers.set("X-RapidAPI-Host", xRapidApiHost);

           //Make a GET call to RapidAPI
           ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

           log.info("Output for ReadyAPI:{}" + responseEntity.getBody());

       }catch (Exception exception){
           log.error("Something went wrong with data from Rapid API", exception);
           throw new ResponseStatusException(
                   HttpStatus.INTERNAL_SERVER_ERROR,
                   "Exception while calling endpoint of RapidAPI for corona",
                   exception);
       }
        return null;
    }
}
