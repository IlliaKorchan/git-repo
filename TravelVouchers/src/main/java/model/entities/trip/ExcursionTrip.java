package model.entities.trip;

import java.util.Optional;
import static view.MessageConstants.EXCURSION_TYPE;

/**
 * POJO class, that represents trips with excursions
 * @author Illia Korchan
 * @version 1.1
 */
public class ExcursionTrip extends Trip {
    private Optional<String[]> excursions;

    public ExcursionTrip(String destination, int pricePerDay, String[] excursions) {
        super(destination, pricePerDay, EXCURSION_TYPE);
        this.excursions = Optional.ofNullable(excursions);
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

    public Optional<String[]> getExcursions() {
        return excursions;
    }

    public void setExcursions(String[] excursions) {
        this.excursions = Optional.ofNullable(excursions);
    }

    @Override
    public Purchaseable purchase() throws CloneNotSupportedException {
        return (Purchaseable) this.clone();
    }

    @Override
    public void close() {}
}
