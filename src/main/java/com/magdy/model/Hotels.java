package com.magdy.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Hotels {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Hotel> hotel;

    public Hotels(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public Hotels() {
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
