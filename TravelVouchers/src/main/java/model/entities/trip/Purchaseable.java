package model.entities.trip;

/**
 * Interface, that points trip entities
 * @author Illia Korchan
 * @version 1.1
 */
public interface Purchaseable extends Cloneable, AutoCloseable{
    Purchaseable purchase() throws CloneNotSupportedException;
    Integer getPricePerDay();
    String getDestination();
    String getType();
}
