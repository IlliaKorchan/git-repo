package model.entities.trip;

import static view.MessageConstants.RELAX_TYPE;

/**
 * POJO class, that represents relax trips
 * @author Illia Korchan
 * @version 1.1
 */
public class RelaxTrip extends Trip {
    private String sea;

    public RelaxTrip(String destination, int pricePerDay, String sea) {
        super(destination, pricePerDay, RELAX_TYPE);
        this.sea = sea;
    }

    public String getSea() {
        return sea;
    }

    public void setSea(String sea) {
        this.sea = sea;
    }

    public String getDestination() {
        return super.getDestination();
    }

    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    public Integer getPricePerDay() {
        return super.getPricePerDay();
    }

    public void setPricePerDay(int pricePerDay) {
        super.setPricePerDay(pricePerDay);
    }

    @Override
    public Purchaseable purchase() throws CloneNotSupportedException {
        return (Purchaseable) this.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void close() {

    }
}
