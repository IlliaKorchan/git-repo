package model.dbimitation;

import model.entities.trip.ExcursionTrip;

import static view.MessageConstants.VIENNA;
import static view.MessageConstants.ROME;
import static view.MessageConstants.SIGHTSEEING;
import static view.MessageConstants.VIENNA_OPERA;
import static view.MessageConstants.COLISEUM;

/**
 * Enum with available trips with excursions
 * @author Illia Korchan
 * @version 1.0
 */
public enum ExcursionTripsAvailable {
    AUSTRIA(new ExcursionTrip(VIENNA, 120, (new String[]{SIGHTSEEING, VIENNA_OPERA}))),
    ITALY(new ExcursionTrip(ROME, 150, (new String[]{SIGHTSEEING, COLISEUM})));

    private ExcursionTrip excursionTrip;

    ExcursionTripsAvailable(ExcursionTrip trip) {
        this.excursionTrip = trip;
    }

    public ExcursionTrip getExcursionTrip() {
        return excursionTrip;
    }
}
