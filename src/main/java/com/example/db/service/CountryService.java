package com.example.db.service;


import com.example.db.dto.CityDto;
import com.example.db.dto.CountryDto;
import com.example.db.dto.PaginationDto;
import com.example.db.dto.StateDto;
import com.example.db.entity.City;
import com.example.db.entity.Country;
import com.example.db.entity.State;
import com.example.db.repository.CityRepository;
import com.example.db.repository.CountryRepository;
import com.example.db.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private CountryRepository countryRepository;
    private CityRepository cityRepository;
    private StateRepository stateRepository;

    public CountryService(CountryRepository countryRepository, CityRepository cityRepository,
                          StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public Response listCountry(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        Page<Country> countries = countryRepository.findAll( pageable);
        if (countries.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok().entity(new PaginationDto(countries.getContent(),countries.getTotalElements(),countries.getTotalPages())).build();
    }

    public Response listCity() {
        List<City> cities = cityRepository.findAll();
        if (cities.isEmpty()) {
            return Response.noContent().build();
        }
            return Response.ok().entity(cities).build();
    }

    public Response listState() {
        List<State> states = stateRepository.findAll();
        if (states.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response addCountry(CountryDto country) {
        Country newCountry = new Country();
        newCountry.setName(country.getName());
        Country saveCountry = countryRepository.save(newCountry);
        if (countryRepository.findById(saveCountry.getId()).isPresent()) {
            String message = "Created";
            return  Response.accepted().entity(message).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response deleteCountry(Long id) {
        if (countryRepository.findById(id).isPresent()) {
            countryRepository.deleteById(id);
            if (countryRepository.findById(id).isPresent()) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            } else return Response.status(Response.Status.OK).build();
        } else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response addCity(CityDto city,long stateId) {
        Optional<State> byId = stateRepository.findById(stateId);
        if(!byId.isPresent()){
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
        City newCity = new City(city.getName(),byId.get());
        newCity.setName(city.getName());
        City saveCity = cityRepository.save(newCity);
        if (cityRepository.findById(saveCity.getId()).isPresent()) {
            return Response.status(Response.Status.ACCEPTED).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response deleteCity(Long id) {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
            if (cityRepository.findById(id).isPresent()) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            } else return Response.status(Response.Status.OK).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response addState(StateDto state, long countryId) {
        Optional<Country> byId = countryRepository.findById(countryId);
        if (!byId.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        State newState = new State(state.getName(), byId.get());
        newState.setName(state.getName());
        State saveState = stateRepository.save(newState);
        if (stateRepository.findById(saveState.getId()).isPresent()) {
            return Response.status(Response.Status.ACCEPTED).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public Response deleteState(Long id) {
        if (stateRepository.findById(id).isPresent()) {
            stateRepository.deleteById(id);
            if (stateRepository.findById(id).isPresent()) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            } else return Response.status(Response.Status.OK).build();
        } else
            return Response.status(Response.Status.BAD_REQUEST).build();
    }
}


