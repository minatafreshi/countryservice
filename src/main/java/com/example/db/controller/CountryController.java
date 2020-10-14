package com.example.db.controller;

import com.example.db.dto.CityDto;
import com.example.db.dto.CountryDto;
import com.example.db.dto.StateDto;

import com.example.db.entity.State;
import com.example.db.service.CountryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Component
@Path("v1")
@Api("v1")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json; charset=utf-8")
    @Path("/countries")
    @ApiOperation("get all Country")
    public Response getAllCountry(@QueryParam("page") @DefaultValue("0") int pageNo, @QueryParam("size") @DefaultValue("10") int pageSize, @QueryParam("name") String name) {
        return countryService.listCountry(pageNo, pageSize, name);
    }

    @POST
    @Produces("application/json; charset=utf-8")
    @Path("/countries")
    public Response createCountry(CountryDto country) {
        return countryService.addCountry(country);
    }

    @DELETE
    @Produces("application/json; charset=utf-8")
    @Path("/countries/{id}")
    public Response deleteCountry(@PathParam("id") long id) {
        return countryService.deleteCountry(id);
    }

    @GET
    @Produces("application/json; charset=urf-8")
    @Path("/states/{countryId}/")
    public Response getAllStates(StateDto state, @PathParam("countryId") long countryId) {
        return countryService.listState(countryId);
    }

    @POST
    @Produces("application/json; charset=utf-8")
    @Path("/countries/{countryId}/state")
    public Response createState(StateDto state, @PathParam("countryId") long countryId) {
        return countryService.addState(state, countryId);
    }

    @DELETE
    @Produces("application/json; charset=utf-8")
    @Path("/states")
    public Response deleteState(long id) {
        return countryService.deleteState(id);
    }

    @GET
    @Produces("application/json; charset=utf-8")
    @Path("/cities/{stateId}/")
    public Response getAllCities(CityDto cityDto, @PathParam("stateId") long stateId) {
        return countryService.listCity(stateId);
    }

    @POST
    @Produces("application/json; charset=utf-8")
    @Path("/states/{stateId}/city")
    public Response createCity(CityDto city, @PathParam("stateId") long stateId) {
        return countryService.addCity(city, stateId);
    }

    @DELETE
    @Produces("application/json; charset=utf-8")
    @Path("cities/{id}")
    public Response deleteCity(@PathParam("id") long id) {
        return countryService.deleteCity(id);
    }
}
