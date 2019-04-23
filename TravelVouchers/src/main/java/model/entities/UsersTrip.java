package model.entities;

import model.dbimitation.Feeding;
import model.dbimitation.Transport;
import model.entities.trip.Purchaseable;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Class for forming user`s order
 * @author Illia Korchan
 * @version 1.1
 */
public class UsersTrip {
    private Optional<Purchaseable> trip;
    private Optional<Feeding> feeding;
    private Optional<Transport> transport;
    private Integer days;

    public UsersTrip() {
    }

    public UsersTrip(Purchaseable trip, Feeding feeding, Transport transport, Integer days) {
        this.trip = Optional.ofNullable(trip);
        this.feeding = Optional.ofNullable(feeding);
        this.transport = Optional.ofNullable(transport);
        this.days = days;
    }

    public Optional<Purchaseable> getTrip() {
        return trip;
    }

    public void setTrip(Purchaseable trip) {
        this.trip = Optional.ofNullable(trip);
    }

    public Optional<Feeding> getFeeding() {
        return feeding;
    }

    public void setFeeding(Feeding feeding) {
        this.feeding = Optional.ofNullable(feeding);
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Optional<Transport> getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = Optional.ofNullable(transport);
    }

    public String totalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(trip.get().getPricePerDay() * days
                            + (trip.get().getPricePerDay() * feeding.get().getAdditionalPrice() * days)
                            + transport.get().getPrice());
        return totalPrice.toString();
    }
}
