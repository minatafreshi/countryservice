package com.example.db.controller;

import com.example.db.dto.CityDto;
import com.example.db.dto.CountryDto;
import com.example.db.dto.StateDto;
import com.example.db.entity.Country;
import com.example.db.entity.State;
import com.example.db.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/*@RestController*/
@Component
@Path("/api/v1")

public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GET
    @Produces("application/json")
    @Path("/countries")
    public Response getAllCountry(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return countryService.listCountry(pageNo, pageSize);
    }

    @POST
    @Produces("application/json")
    @Path("/countries")
    public Response createCountry(@RequestBody CountryDto country) {
        return countryService.addCountry(country);
    }

    @DELETE
    @Produces("application/json")
    @Path("/countries/{id}")
    public Response deleteCountry(@PathVariable Long id) {
        return countryService.deleteCountry(id);
    }

    @GET
    @Produces("application/json")
    @Path("/states")
    public Response getAllStates() {
        return countryService.listState();
    }

    @POST
    @Produces("application/json")
    @Path("/countries/{countryId}/{state}")
    public Response createState(@RequestBody StateDto state, @PathVariable long countryId) {
        return countryService.addState(state, countryId);
    }

    @DELETE
    @Produces("application/json")
    @Path("/states")
    public Response deleteState(@PathVariable Long id) {
        return countryService.deleteState(id);
    }

    @GET
    @Produces("application/json")
    @Path("/cities")
    public Response getAllCities() {
        return countryService.listCity();
    }

    @POST
    @Produces("application/json")
    @Path("/states/{stateId}/city")
    public Response createCity(@RequestBody CityDto city, @PathVariable Long stateId) {
        return countryService.addCity(city, stateId);
    }

    @DELETE
    @Produces("application/json")
    @Path("cities/{id}")
    public Response deleteCity(@PathVariable Long id) {
        return countryService.deleteCity(id);
    }



    /*@GetMapping(value = "/countries")
    public ResponseEntity<Object> getAllCountry(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return countryService.listCountry(pageNo, pageSize);
    }*/

   /* @PostMapping("/countries")
    public ResponseEntity<Object> createCountry(@RequestBody CountryDto country) {
        return countryService.addCountry(country);
    }*/

    /*@DeleteMapping("/countries/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable Long id) {
        return countryService.deleteCountry(id);
    }*/

  /*  @GetMapping("states")
    public  ResponseEntity<Object> getAllStates() {
        return countryService.listState();
    }*/

    /*@PostMapping("/countries/{countryId}/state")
    public ResponseEntity<Object> createState(@RequestBody StateDto state, @PathVariable long countryId) {
        return countryService.addState(state, countryId);
    }*/

    /*@DeleteMapping("/states")
    public ResponseEntity<Object> deleteState(@PathVariable Long id) {
        return countryService.deleteState(id);
    }*/

/*    @GetMapping("cities")
    public ResponseEntity<Object> getAllCities() {
        return countryService.listCity();
    }*/

    /*@PostMapping("states/{stateId}/city")
    public ResponseEntity<Object> createCity(@RequestBody CityDto city, @PathVariable long stateId) {
        return countryService.addCity(city, stateId);
    }*/

/*    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Object> deleteCity(@PathVariable Long id) {
        return countryService.deleteCity(id);
    }*/
}
