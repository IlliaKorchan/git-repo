package model.entities.trip;

/**
 * Abstract class for pointing trips
 * @author Illia Korchan
 * @version 1.0
 */
public abstract class Trip implements Purchaseable {
    private String destination;
    private Integer pricePerDay;

    public Trip(String destination, int pricePerDay) {
        this.destination = destination;
        this.pricePerDay = pricePerDay;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
