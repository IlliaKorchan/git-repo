package model.entities.trip;

/**
 * POJO class, that represents trips with excursions
 * @author Illia Korchan
 * @version 1.0
 */
public class ExcursionTrip extends Trip {
    private String[] excursions;

    public ExcursionTrip(String destination, int pricePerDay, String[] excursions) {
        super(destination, pricePerDay);
        this.excursions = isNotNull(excursions);
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

    public String[] getExcursions() {
        return excursions;
    }

    public void setExcursions(String[] excursions) {
        this.excursions = isNotNull(excursions);
    }

    @Override
    public Purchaseable purchase() throws CloneNotSupportedException {
        return (Purchaseable) this.clone();
    }

    /**
     * Method that checks if array with available excursions has null value
     * @param listToCheck
     * @return listToCheck not null
     */
    public String[] isNotNull(String[] listToCheck) {
        if (listToCheck != null) {
            return listToCheck;
        } else {
            throw new NullPointerException();
        }
    }
}
