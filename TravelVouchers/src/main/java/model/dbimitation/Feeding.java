package model.dbimitation;

import static view.MessageConstants.NOT_PROVIDED;
import static view.MessageConstants.ONLY_BREAKFAST;
import static view.MessageConstants.THREE_TIMES;
import static view.MessageConstants.ALL_INCLUSIVE;

/**
 * Enum with available types of feeding
 * @author Illia Korchan
 * @version 1.0
 */
public enum Feeding {
    NOT_PROVIDED_NAME(NOT_PROVIDED, 0),
    ONLY_BREAKFAST_NAME(ONLY_BREAKFAST, 0.05),
    THREE_TIMES_NAME(THREE_TIMES, 0.1),
    ALL_INCLUSIVE_NAME(ALL_INCLUSIVE, 0.2);

    private String name;
    private double additionalPrice;

    Feeding(String name ,double additionalPrice) {
        this.name = name;
        this.additionalPrice = additionalPrice;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public String getName() {
        return name;
    }
}
