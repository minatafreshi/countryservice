package com.example.db.dto;

public class CityDto {
    private Long id;
    private String name;
    private String stateName;
    private String countryName;

    public CityDto(String name, Long id, String stateName, String countryName) {
        this.name = name;
        this.id = id;
        this.stateName = stateName;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }
}
