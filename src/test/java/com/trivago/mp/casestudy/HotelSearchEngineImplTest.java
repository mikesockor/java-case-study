package com.trivago.mp.casestudy;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class HotelSearchEngineImplTest {

    @Test
    public void initialize() {

        Date firstDate = new Date();
        HotelSearchEngine hotelSearchEngine = new HotelSearchEngineImpl();
        Date secondDate = new Date();

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        System.out.println("Difference " + diffInMillies);

        try {
            hotelSearchEngine.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}