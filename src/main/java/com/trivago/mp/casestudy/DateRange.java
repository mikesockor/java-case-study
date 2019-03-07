package com.trivago.mp.casestudy;

/**
 * Simple class that specifies the arrival and departure day of a hotel stay. Stored as an integer in the format
 * YYYYMMDD
 */
public class DateRange {
    private final int startDate;
    private final int endDate;

    /**
     * Instantiates a new Date range.
     *
     * @param startDate the start date
     * @param endDate   the end date
     */
    public DateRange(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public int getEndDate() {
        return endDate;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public int getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "DateRange{" + "startDate=" + startDate + ", endDate=" + endDate + '}';
    }
}
