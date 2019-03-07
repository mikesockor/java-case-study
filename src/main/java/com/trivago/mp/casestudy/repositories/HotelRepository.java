package com.trivago.mp.casestudy.repositories;

import com.trivago.mp.casestudy.Hotel;
import java.util.Map;

/**
 * The interface Hotel repository.
 */
public interface HotelRepository {

    /**
     * Find all map.
     *
     * @return the map
     */
    Map<Integer, Hotel> findAll();

    /**
     * Find by id hotel.
     *
     * @param id the id
     * @return the hotel
     */
    Hotel findById(Integer id);

    /**
     * Save all.
     *
     * @param hotels the hotels
     */
    void saveAll(final Map<Integer, Hotel> hotels);

}
