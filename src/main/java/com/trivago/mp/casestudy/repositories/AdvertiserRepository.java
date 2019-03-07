package com.trivago.mp.casestudy.repositories;

import com.trivago.mp.casestudy.Advertiser;
import java.util.Map;

/**
 * The interface Advertiser repository.
 */
public interface AdvertiserRepository {

    /**
     * Find all map.
     *
     * @return the map
     */
    Map<Integer, Advertiser> findAll();

    /**
     * Find by id advertiser.
     *
     * @param id the id
     * @return the advertiser
     */
    Advertiser findById(Integer id);

    /**
     * Save all.
     *
     * @param advertisers the advertisers
     */
    void saveAll(final Map<Integer, Advertiser> advertisers);
}
