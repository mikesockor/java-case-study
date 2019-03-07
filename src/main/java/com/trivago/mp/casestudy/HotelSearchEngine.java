package com.trivago.mp.casestudy;

import java.util.List;

/**
 * The main interface for our search engine.
 */
public interface HotelSearchEngine {
    /**
     * An init function that reads all necessary data from disk, sets up necessary data structures, etc.
     */
    void initialize();

    /**
     * The actual search engine functionality. Given the search context (the city as a String and the date range),
     * perform the search by using the OfferProvider interface.
     *
     * @param cityName      the city name
     * @param dateRange     the date range
     * @param offerProvider the offer provider
     * @return list
     */
    List<HotelWithOffers> performSearch(String cityName, DateRange dateRange, OfferProvider offerProvider);
}
