package model.dbimitation;

import static view.MessageConstants.BUS;
import static view.MessageConstants.SHIP;
import static view.MessageConstants.PLANE;
import static view.MessageConstants.TRAIN;

/**
 * Enum with available types of transport
 * @author Illia Korchan
 * @version 1.0
 */
public enum Transport {
    BY_BUS(BUS, 200), BY_SHIP(SHIP, 400), BY_PLANE(PLANE, 800), BY_TRAIN(TRAIN, 300);

    private String name;
    private int price;

    Transport(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
