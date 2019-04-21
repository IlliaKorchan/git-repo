package controller;

import model.dbimitation.ExcursionTripsAvailable;
import model.dbimitation.Feeding;
import model.dbimitation.RelaxTripsAvailable;
import model.dbimitation.Transport;

import model.entities.UsersTrip;
import model.entities.trip.ExcursionTrip;
import model.entities.trip.Purchaseable;
import model.entities.trip.RelaxTrip;

import view.MessageConstants;
import view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class, that checks input data and process trip selection
 * @author Illia Korchan
 * @version 1.0
 */
public class Controller implements MessageConstants {
    private View view;
    private ResourceBundle bundle;
    private Scanner scanner = new Scanner(System.in);

    public Controller(View view) {
        this.view = view;
    }

    /**
     * Method for starting selection process
     */
    public void chooseTrip() {
        setLanguage();
        typeSelect();
    }

    /**
     * Method for setting language
     */
    public void setLanguage() {
        for (; ; ) {
            view.printMessages(CHOOSE_LANGUAGE_MESSAGE);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(POSITIVE_ANSWER)) {
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, new Locale("uk", "UA"));
                return;
            } else if (answer.equalsIgnoreCase(NEGATIVE_ANSWER)) {
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, new Locale("", ""));
                return;
            } else {
                view.printMessages(INCORRECT_ANSWER_MESSAGE);
                continue;
            }
        }
    }

    /**
     * Method for choosing type of trip
     */
    public void typeSelect() {
        view.printMessages(view.createMessage(bundle.getString(CHOOSE_TYPE_MESSAGE),
                bundle.getString(HOW_TO_CHOOSE_MESSAGE),
                DOUBLE_DOT),
                view.createMessage(VARIANTS[0], DASH, bundle.getString(RELAX_TYPE)),
                view.createMessage(VARIANTS[1], DASH, bundle.getString(EXCURSION_TYPE)),
                view.createMessage(VARIANTS[2], DASH, bundle.getString(EXIT_MESSAGE))
        );

        int type = select(Integer.parseInt(VARIANTS[2]));
        switch (type) {
            case 1: {
                usersOrder(getRelaxTrips());
                break;
            }
            case 2: {
                usersOrder(getExcursionTrips());
                break;
            }
            case 3: {
                exit();
            }
        }
    }

    /**
     * Method for displaying and choosing types of relax trips
     * @return selected trip
     */
    public RelaxTrip getRelaxTrips() {
        chooseTripMessage();
        RelaxTrip trip;

        for (int i = 0; i < RelaxTripsAvailable.values().length; i++) {
            trip = RelaxTripsAvailable.values()[i].getRelaxTrip();
            view.printMessages(view.createMessage(VARIANTS[i], DASH, bundle.getString(trip.getDestination()),
                                                  COMMA, trip.getPricePerDay().toString(),
                                                  bundle.getString(PRICE_MESSAGE),
                                                  COMMA, bundle.getString(trip.getSea()), bundle.getString(SEA)
                                                 ));
        }

        RelaxTrip selectedTrip = null;
        try {
            selectedTrip = (RelaxTrip) ((RelaxTripsAvailable.values()[select(RelaxTripsAvailable.values().length) - 1]
                                        .getRelaxTrip()).purchase());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return selectedTrip;
    }

    /**
     * Method for displaying and choosing types of trips with excursions
     * @return selected trip
     */
    public ExcursionTrip getExcursionTrips() {
        chooseTripMessage();
        ExcursionTrip trip;

        for (int i = 0; i < ExcursionTripsAvailable.values().length; i++) {
            trip = ExcursionTripsAvailable.values()[i].getExcursionTrip();
            view.printMessages(view.createMessage(VARIANTS[i], DASH, bundle.getString(trip.getDestination()),
                                                  COMMA, (trip.getPricePerDay()).toString(),
                                                  bundle.getString(PRICE_MESSAGE)
                                                 ));

            view.printMessages(view.createMessage(bundle.getString(EXCURSION_MESSAGE), DOUBLE_DOT));
            for (int j = 0; j < trip.getExcursions().length; j++) {
                view.printMessages(bundle.getString(trip.getExcursions()[j]));
            }
        }

        ExcursionTrip selectedTrip = null;
        try {
            selectedTrip = (ExcursionTrip) (ExcursionTripsAvailable.values()[select(ExcursionTripsAvailable.values().length) - 1]
                    .getExcursionTrip().purchase());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return selectedTrip;
    }

    /**
     * Method, that creates and shows users order
     * @param  selectedTrip by user
     */
    public void usersOrder(Purchaseable selectedTrip) {
        UsersTrip userSelection = new UsersTrip();

        userSelection.setTrip(selectedTrip);
        userSelection.setFeeding(feedingSelect());
        userSelection.setTransport(transportSelect());
        userSelection.setDays(daysSelect());

        view.printMessages(view.createMessage(bundle.getString(USERS_ORDER_MESSAGE),
                bundle.getString(userSelection.getTrip().getDestination())),
                view.createMessage(bundle.getString(USERS_ORDER_FEEDING),
                        bundle.getString(userSelection.getFeeding().getName())),
                view.createMessage(bundle.getString(USERS_ORDER_TRANSPORT),
                        bundle.getString(userSelection.getTransport().getName())),
                view.createMessage(bundle.getString(USERS_ORDER_FOR), userSelection.getDays().toString(),
                        bundle.getString(USERS_ORDER_DAYS)),
                view.createMessage(bundle.getString(USERS_TOTAL_PRICE), userSelection.totalPrice(),
                        CURRENCY)
        );
    }

    /**
     * Method for choosing type of feeding
     * @return selected feeding
     */
    public Feeding feedingSelect() {
        view.printMessages(view.createMessage(bundle.getString(CHOOSE_FEEDING_MESSAGE),
                bundle.getString(HOW_TO_CHOOSE_MESSAGE),
                DOUBLE_DOT));

        for (int i = 0; i < Feeding.values().length; i++) {
            view.printMessages(view.createMessage(VARIANTS[i], DASH, bundle.getString(Feeding.values()[i].getName())));
        }

        return Feeding.values()[select(Feeding.values().length) - 1];
    }

    /**
     * Method for choosing type of transport
     * @return selected transport
     */
    public Transport transportSelect() {
        view.printMessages(view.createMessage(bundle.getString(CHOOSE_TRANSPORT_MESSAGE), bundle.getString(HOW_TO_CHOOSE_MESSAGE), DOUBLE_DOT));

        for (int i = 0; i < Transport.values().length; i++) {
            view.printMessages(view.createMessage(VARIANTS[i], DASH, bundle.getString(Transport.values()[i].getName())));
        }

        return Transport.values()[select(Transport.values().length) - 1];
    }

    /**
     * Method for checking entered variant
     * @param variantsAmount amount of allowed variants
     * @return selected variant
     */
    public int select(Integer variantsAmount) {
        if (!variantsAmount.toString().matches(VARIANT_REGEX)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (; ; ) {
                String variant = scanner.nextLine();
                if (variant.matches(VARIANT_REGEX)) {
                    int intVariant = Integer.parseInt(variant);

                    if ((intVariant >= Integer.parseInt(VARIANTS[0])) &&
                            (intVariant <= Integer.parseInt(VARIANTS[variantsAmount - 1]))) {
                        return intVariant;
                    } else {
                        view.printMessages(view.createMessage(bundle.getString(INCORRECT_CHOOSING_MESSAGE),
                                VARIANTS[0],
                                bundle.getString(TO),
                                VARIANTS[variantsAmount - 1]));
                        continue;
                    }
                } else {
                    view.printMessages(view.createMessage(bundle.getString(INCORRECT_CHOOSING_MESSAGE),
                            VARIANTS[0],
                            bundle.getString(TO),
                            VARIANTS[variantsAmount - 1]));
                    continue;
                }
            }
        }
    }

    /**
     * Method for choosing number of days in a trip
     * @return number of days
     */
    public int daysSelect() {
        for (; ; ) {
            view.printMessages(view.createMessage(bundle.getString(CHOOSE_DAYS_MESSAGE),
                                                  bundle.getString(DAYS_RANGE),
                                                  DOUBLE_DOT));

            String insertedValue = scanner.nextLine();
            if (insertedValue.matches(DIGITS_REGEX)) {
                int days = Integer.parseInt(insertedValue);

                if ((days >= DAYS_MINIMUM) && (days <= DAYS_MAXIMUM)) {
                    return days;
                } else {
                    view.printMessages(view.createMessage(bundle.getString(INCORRECT_DAYS_CHOOSE_MESSAGE),
                                                          bundle.getString(DAYS_RANGE)));
                    continue;
                }
            } else {
                view.printMessages(view.createMessage(bundle.getString(INCORRECT_DAYS_CHOOSE_MESSAGE),
                                                      bundle.getString(DAYS_RANGE)));
                continue;
            }
        }
    }

    /**
     * Method for displaying message and proposing to choose a type of trip
     */
    public void chooseTripMessage() {
        view.printMessages(view.createMessage(bundle.getString(CHOOSE_TRIP_MESSAGE),
                                              bundle.getString(HOW_TO_CHOOSE_MESSAGE),
                                              DOUBLE_DOT));
    }

    /**
     * Method, that finishes program working
     */
    public void exit() {
        view.printMessages(bundle.getString(GOODBYE_MESSAGE));
        System.exit(0);
    }
}

