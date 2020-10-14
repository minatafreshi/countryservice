package com.example.db.dto;

public class StateDto {
    private Long id;
    private String name;
    private int number;
    private String countryName;
    //private String cityName;

    public StateDto() {
    }

    public StateDto(String name, String countryName, int number) {
        this.name = name;
        this.number = number;
        this.countryName = countryName;
        //this.cityName = cityName;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
}
