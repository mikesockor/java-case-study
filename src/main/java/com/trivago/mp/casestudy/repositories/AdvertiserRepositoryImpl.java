package com.trivago.mp.casestudy.repositories;

import com.trivago.mp.casestudy.Advertiser;
import java.util.Map;

/**
 * The type Advertiser repository.
 */
public class AdvertiserRepositoryImpl implements AdvertiserRepository {

    private Map<Integer, Advertiser> advertisers;

    @Override
    public Map<Integer, Advertiser> findAll() {
        return advertisers;
    }

    @Override public Advertiser findById(Integer id) {
        return advertisers.get(id);
    }

    @Override
    public void saveAll(final Map<Integer, Advertiser> advertisers) {
        this.advertisers = advertisers;
    }
}
