package com.trivago.mp.casestudy.repositories;

import java.util.Map;

/**
 * The interface Hotel metrics.
 */
public interface HotelMetrics {

    /**
     * Gets hotel clicks.
     *
     * @return the hotel clicks
     */
    Map<Integer, Long> getHotelClicks();

    /**
     * Sets hotel clicks.
     *
     * @param hotelClicks the hotel clicks
     */
    void setHotelClicks(final Map<Integer, Long> hotelClicks);

    /**
     * Gets hotel impression.
     *
     * @return the hotel impression
     */
    Map<Integer, Long> getHotelImpression();

    /**
     * Sets hotel impression.
     *
     * @param hotelImpression the hotel impression
     */
    void setHotelImpression(final Map<Integer, Long> hotelImpression);

}
