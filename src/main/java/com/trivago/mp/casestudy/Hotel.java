package com.trivago.mp.casestudy;

/**
 * Stores all relevant information about a particular hotel.
 */
public class Hotel {
    private final int    id;
    private final String cityName;
    private final String name;
    private final int    rating;
    private final int    stars;

    /**
     * Instantiates a new Hotel.
     *
     * @param id       the id
     * @param cityName the city name
     * @param name     the name
     * @param rating   the rating
     * @param stars    the stars
     */
    public Hotel(int id, String cityName, String name, int rating, int stars) {
        this.id = id;
        this.cityName = cityName;
        this.name = name;
        this.rating = rating;
        this.stars = stars;
    }

    /**
     * A unique id as specified in the corresponding .csv file
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * The English name of the hotel
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * The ratings given by user feedback, between 0-100
     *
     * @return rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * The star rating for the given hotel, between 1-5
     *
     * @return stars
     */
    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", name='" + name + '\'' + ", rating=" + rating + ", stars=" + stars + '}';
    }
}
