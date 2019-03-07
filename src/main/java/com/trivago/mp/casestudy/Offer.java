package com.trivago.mp.casestudy;

/**
 * A concrete offer from a specific advertiser
 */
public class Offer {
    private final Advertiser advertiser;
    private final int        priceInEuro;
    private final int        cpc;

    /**
     * Instantiates a new Offer.
     *
     * @param advertiser  the advertiser
     * @param priceInEuro the price in euro
     * @param cpc         the cpc
     */
    public Offer(Advertiser advertiser, int priceInEuro, int cpc) {
        this.advertiser = advertiser;
        this.priceInEuro = priceInEuro;
        this.cpc = cpc;
    }

    /**
     * Gets advertiser.
     *
     * @return the advertiser
     */
    public Advertiser getAdvertiser() {
        return advertiser;
    }

    /**
     * Gets price in euro.
     *
     * @return the price in euro
     */
    public int getPriceInEuro() {
        return priceInEuro;
    }

    /**
     * the cost per click an advertiser pays for a particular offer
     *
     * @return the cpc
     */
    public int getCpc() {
        return cpc;
    }

    @Override
    public String toString() {
        return "Offer{" + "advertiser=" + advertiser + ", priceInEuro=" + priceInEuro + ", cpc=" + cpc + '}';
    }
}
