package model.entities.trip;

/**
 * Interface, that points trip entities
 * @author Illia Korchan
 * @version 1.0
 */
public interface Purchaseable extends Cloneable{
    Purchaseable purchase() throws CloneNotSupportedException;
    Integer getPricePerDay();
    String getDestination();
}
