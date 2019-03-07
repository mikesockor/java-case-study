package com.trivago.mp.casestudy;

import java.util.List;

/**
 * Wraps a hotel and a list of {@link Offer Offers}.
 */
public class HotelWithOffers {

    private final Hotel hotel;

    /**
     * A list of concrete advertiser offers for this hotel
     */
    List<Offer> offers;

    /**
     * Instantiates a new Hotel with offers.
     *
     * @param hotel  the hotel
     * @param offers the offers
     */
    public HotelWithOffers(Hotel hotel, List<Offer> offers) {
        this.hotel = hotel;
        this.offers = offers;
    }

    /**
     * Gets hotel.
     *
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Gets offers.
     *
     * @return the offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    @Override
    public String toString() {
        return "HotelWithOffers{" + "hotel=" + hotel + ", offers=" + offers + '}';
    }
}
