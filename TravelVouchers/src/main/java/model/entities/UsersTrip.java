package model.entities;

import model.dbimitation.Feeding;
import model.dbimitation.Transport;
import model.entities.trip.Purchaseable;

/**
 * Class for forming user`s order
 * @author Illia Korchan
 * @version 1.0
 */
public class UsersTrip {
    private Purchaseable trip;
    private Feeding feeding;
    private Transport transport;
    private Integer days;

    public UsersTrip() {
    }

    public UsersTrip(Purchaseable trip, Feeding feeding, Transport transport, Integer days) {
        this.trip = isNotNull(trip);
        this.feeding = feeding;
        this.transport = transport;
        this.days = days;
    }

    public Purchaseable getTrip() {
        return trip;
    }

    public void setTrip(Purchaseable trip) {
        this.trip = trip;
    }

    public Feeding getFeeding() {
        return feeding;
    }

    public void setFeeding(Feeding feeding) {
        this.feeding = feeding;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Purchaseable isNotNull(Purchaseable tripToCheck) {
        if (tripToCheck != null) {
            return tripToCheck;
        } else {
            throw new NullPointerException();
        }
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String totalPrice() {
        Double totalPrice = trip.getPricePerDay() * days
                            + (trip.getPricePerDay() * feeding.getAdditionalPrice() * days)
                            + transport.getPrice();
        return totalPrice.toString();
    }
}
