package model.entities.trip;

/**
 * Abstract class for pointing trips
 * @author Illia Korchan
 * @version 1.1
 */
public abstract class Trip implements Purchaseable {
    private String destination;
    private Integer pricePerDay;
    private String type;

    public Trip(String destination, int pricePerDay, String type) {
        this.destination = destination;
        this.pricePerDay = pricePerDay;
        this.type = type;
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

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
