package com.trivago.mp.casestudy.repositories;

import com.trivago.mp.casestudy.Hotel;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Hotel repository.
 */
public class HotelRepositoryImpl implements HotelRepository {

    private Map<Integer, Hotel> hotels = new HashMap<>();

    @Override
    public Map<Integer, Hotel> findAll() {
        return hotels;
    }

    @Override public Hotel findById(Integer id) {
        return hotels.get(id);
    }

    @Override
    public void saveAll(final Map<Integer, Hotel> hotels) {
        this.hotels = hotels;
    }
}
