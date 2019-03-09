package com.trivago.mp.casestudy.repositories;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Hotel metrics.
 */
public class HotelMetricsImpl implements HotelMetrics {

    private Map<Integer, Long> hotelClicks = new HashMap<>();

    private Map<Integer, Long> hotelImpression = new HashMap<>();

    @Override
    public Map<Integer, Long> getHotelClicks() {
        return hotelClicks;
    }

    @Override
    public void setHotelClicks(final Map<Integer, Long> hotelClicks) {
        this.hotelClicks = hotelClicks;
    }

    @Override
    public Map<Integer, Long> getHotelImpression() {
        return hotelImpression;
    }

    @Override
    public void setHotelImpression(final Map<Integer, Long> hotelImpression) {
        this.hotelImpression = hotelImpression;
    }
}
