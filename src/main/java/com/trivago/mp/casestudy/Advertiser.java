package com.trivago.mp.casestudy;

/**
 * Stores the id and name of an advertiser. An Advertiser is a company provides offers for hotel stays.
 */
public class Advertiser {
    private final int    id;
    private final String name;

    /**
     * Instantiates a new Advertiser.
     *
     * @param id   the id
     * @param name the name
     */
    public Advertiser(int id, String name) {
        this.id = id;
        this.name = name;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Advertiser{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
