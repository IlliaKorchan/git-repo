package controller;

import model.dbimitation.ExcursionTripsAvailable;
import model.dbimitation.Feeding;
import model.dbimitation.RelaxTripsAvailable;
import model.dbimitation.Transport;

import model.entities.UsersTrip;
import model.entities.trip.Purchaseable;

import view.MessageConstants;
import view.View;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class, that checks input data and process trip selection
 * @author Illia Korchan
 * @version 1.0
 */
public class Controller implements MessageConstants {
    private View view;
    private ResourceBundle bundle;
    private Scanner scanner = new Scanner(System.in);
    private List<Purchaseable>offerList = new ArrayList<>();

    public Controller(View view) {
        this.view = view;
    }

    /**
     * Method for starting selection process
     */
    public void chooseTrip() {
        fillOfferList();
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
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,
                                                  new Locale("uk", "UA"));
                return;
            } else if (answer.equalsIgnoreCase(NEGATIVE_ANSWER)) {
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,
                                                  new Locale("", ""));
                return;
            } else {
                view.printMessages(INCORRECT_ANSWER_MESSAGE);
            }
        }
    }

    /**
     * Method for choosing type of trip
     */
    public void typeSelect() {
        chooseMessage(CHOOSE_TYPE_MESSAGE);
        view.printMessages(view.createMessage(VARIANTS[0], DASH, bundle.getString(RELAX_TYPE)),
                           view.createMessage(VARIANTS[1], DASH, bundle.getString(EXCURSION_TYPE)),
                           view.createMessage(VARIANTS[2], DASH, bundle.getString(EXIT_MESSAGE)));

        int type = select(Integer.parseInt(VARIANTS[2]));
        switch (type) {
            case 1: {
                filterTripsByType(RELAX_TYPE);
                break;
            }
            case 2: {
                filterTripsByType(EXCURSION_TYPE);
                break;
            }
            case 3: {
                exit();
            }
        }
        order();
    }

    /**
     * Method for choosing trip
     * @return selectedTrip
     */
    public Purchaseable tripSelect() {
        chooseMessage(CHOOSE_TRIP_MESSAGE);

        IntStream.range(0, Math.min(VARIANTS.length, offerList.size()))
                .forEach((i) ->  view.printMessages(view.createMessage(VARIANTS[i], DASH,
                        bundle.getString(offerList.get(i).getDestination()),
                        COMMA, (offerList.get(i).getPricePerDay()).toString(),
                        bundle.getString(PRICE_MESSAGE))));

        try (Purchaseable selectedTrip = offerList.get(select(offerList.size()) - 1).purchase()) {
            return selectedTrip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for choosing type of feeding
     * @return selected feeding
     */
    public <T> T feedingTransportSelect(T[] toChoose, String message) {
        chooseMessage(message);

        IntStream.range(0, Math.min(VARIANTS.length, toChoose.length))
                .forEach((i) ->  view.printMessages(view.createMessage(VARIANTS[i], DASH,
                        bundle.getString(toChoose[i].toString()))));

        return toChoose[select(toChoose.length) - 1];
    }

    /**
     * Method, that creates and shows users order
     */
    public void order() {
        UsersTrip userSelection = new UsersTrip();

        userSelection.setTrip(tripSelect());
        userSelection.setFeeding(feedingTransportSelect(Feeding.values(), CHOOSE_FEEDING_MESSAGE));
        userSelection.setTransport(feedingTransportSelect(Transport.values(), CHOOSE_TRANSPORT_MESSAGE));

        view.printMessages(view.createMessage(bundle.getString(CHOOSE_DAYS_MESSAGE),
                                              bundle.getString(DAYS_RANGE),
                                              DOUBLE_DOT));
        userSelection.setDays(select(DAYS_MAXIMUM));

        view.printMessages(view.createMessage(bundle.getString(USERS_ORDER_MESSAGE),
                bundle.getString(userSelection.getTrip().get().getDestination())),
                view.createMessage(bundle.getString(USERS_ORDER_FEEDING),
                        bundle.getString(userSelection.getFeeding().get().getName())),
                view.createMessage(bundle.getString(USERS_ORDER_TRANSPORT),
                        bundle.getString(userSelection.getTransport().get().getName())),
                view.createMessage(bundle.getString(USERS_ORDER_FOR), userSelection.getDays().toString(),
                        bundle.getString(USERS_ORDER_DAYS)),
                view.createMessage(bundle.getString(USERS_TOTAL_PRICE), userSelection.totalPrice(),
                        CURRENCY)
        );
    }

    /**
     * Method for checking entered variant
     * @param variantsAmount amount of allowed variants
     * @return selected variant
     */
    public int select(Integer variantsAmount) {
        while(true) {
            String variant = scanner.nextLine();
            if ((variant.matches(DIGITS_REGEX)) &&
                    (Integer.parseInt(variant) <= variantsAmount) &&
                    (Integer.parseInt(variant) > FLOOR)) {
                return Integer.parseInt(variant);
            } else {
                view.printMessages(view.createMessage(bundle.getString(INCORRECT_CHOOSING_MESSAGE),
                        VARIANTS[0],
                        bundle.getString(TO),
                        variantsAmount.toString()));
                continue;
            }
        }
    }

    /**
     * Method for displaying message and proposing to choose data
     */
    public void chooseMessage(String toChoose) {
        view.printMessages(view.createMessage(bundle.getString(toChoose),
                bundle.getString(HOW_TO_CHOOSE_MESSAGE),
                DOUBLE_DOT));
    }

    /**
     * Method for filtering offerings by type
     * @param type
     */
    public void filterTripsByType(String type) {
        offerList = offerList.stream()
                             .filter(trip -> trip.getType().equals(type))
                             .collect(Collectors.toList());
    }

    /**
     * Method for filling list by all of available offerings
     */
    public void fillOfferList() {
        offerList = Stream.concat(Arrays.stream(RelaxTripsAvailable.values())
                        .map(RelaxTripsAvailable::getTrip),
                Arrays.stream(ExcursionTripsAvailable.values())
                        .map(ExcursionTripsAvailable::getTrip))
                .sorted(Comparator.comparing(Purchaseable::getPricePerDay))
                .collect(Collectors.toList());
    }

    /**
     * Method, that finishes program working
     */
    public void exit() {
        view.printMessages(bundle.getString(GOODBYE_MESSAGE));
        System.exit(0);
    }
}