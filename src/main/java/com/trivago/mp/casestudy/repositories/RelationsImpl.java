package com.trivago.mp.casestudy.repositories;

import java.util.List;
import java.util.Map;

/**
 * The type Relations.
 */
public class RelationsImpl implements Relations {

    private Map<Integer, List<Integer>> advertiserHotel;

    private Map<Integer, List<Integer>> hotelAdvertiser;

    @Override
    public Map<Integer, List<Integer>> getAdvertiserHotel() {
        return advertiserHotel;
    }

    @Override
    public void setAdvertiserHotel(final Map<Integer, List<Integer>> advertiserHotel) {
        this.advertiserHotel = advertiserHotel;
    }

    @Override
    public Map<Integer, List<Integer>> getHotelAdvertiser() {
        return hotelAdvertiser;
    }

    @Override
    public void setHotelAdvertiser(final Map<Integer, List<Integer>> hotelAdvertiser) {
        this.hotelAdvertiser = hotelAdvertiser;
    }

}
