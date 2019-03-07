package com.trivago.mp.casestudy.repositories;

import java.util.List;
import java.util.Map;

//We follow the "redundancy principle" for faster searching.

/**
 * The interface Relations.
 */
public interface Relations {

    /**
     * Gets advertiser hotel.
     *
     * @return the advertiser hotel
     */
    Map<Integer, List<Integer>> getAdvertiserHotel();

    /**
     * Sets advertiser hotel.
     *
     * @param advertiserHotel the advertiser hotel
     */
    void setAdvertiserHotel(final Map<Integer, List<Integer>> advertiserHotel);

    /**
     * Gets hotel advertiser.
     *
     * @return the hotel advertiser
     */
    Map<Integer, List<Integer>> getHotelAdvertiser();

    /**
     * Sets hotel advertiser.
     *
     * @param hotelAdvertiser the hotel advertiser
     */
    void setHotelAdvertiser(final Map<Integer, List<Integer>> hotelAdvertiser);

}
