package model.dbimitation;

import model.entities.trip.RelaxTrip;

import static view.MessageConstants.ANTALYA;
import static view.MessageConstants.HURGHADA;
import static view.MessageConstants.ATHENS;
import static view.MessageConstants.MEDITERRANEAN;
import static view.MessageConstants.RED;
import static view.MessageConstants.AEGEAN;

/**
 * Enum with available relax trips
 * @author Illia Korchan
 * @version 1.1
 */
public enum RelaxTripsAvailable {
    TURKEY(new RelaxTrip(ANTALYA , 80, MEDITERRANEAN)),
    EGYPT(new RelaxTrip(HURGHADA, 90, RED)),
    GREECE(new RelaxTrip(ATHENS, 120, AEGEAN));

    private RelaxTrip trip;

    RelaxTripsAvailable(RelaxTrip relaxTrip) {
        this.trip = relaxTrip;
    }

    public RelaxTrip getTrip() {
        return trip;
    }
}
