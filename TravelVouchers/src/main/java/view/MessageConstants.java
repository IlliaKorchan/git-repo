package view;

/**
 * Interface - container for constant fields
 * @author Illia Korchan
 * @version 1.1
 */
public interface MessageConstants {
    String MESSAGE_BUNDLE_NAME = "messages";

    String CHOOSE_LANGUAGE_MESSAGE = "Do you want to change language to Ukrainian?(y/n):";
    String INCORRECT_ANSWER_MESSAGE = "Incorrect input! You can use \"y\" or \"n\".";

    String INCORRECT_CHOOSING_MESSAGE = "message.choose.incorrect";
    String CHOOSE_TYPE_MESSAGE = "message.choose.type";
    String HOW_TO_CHOOSE_MESSAGE = "message.choose.howto";
    String TO = "message.choose.to";
    String EXIT_MESSAGE = "message.exit";
    String GOODBYE_MESSAGE = "message.goodbye";
    String PRICE_MESSAGE = "message.price";
    String SEA = "message.sea";
    String EXCURSION_MESSAGE = "message.excursions";
    String CHOOSE_TRIP_MESSAGE = "message.choose.trip";
    String CHOOSE_FEEDING_MESSAGE = "message.choose.feeding";
    String CHOOSE_TRANSPORT_MESSAGE = "message.choose.transport";
    String CHOOSE_DAYS_MESSAGE = "message.choose.days";
    String USERS_ORDER_MESSAGE = "message.users.order";
    String USERS_ORDER_FEEDING = "message.users.feeding";
    String USERS_ORDER_TRANSPORT = "message.users.transport";
    String USERS_ORDER_FOR = "message.users.for";
    String USERS_ORDER_DAYS = "message.users.days";
    String USERS_TOTAL_PRICE = "message.users.totalprice";
    String DAYS_RANGE = "message.choose.range.days";

    String RELAX_TYPE = "type.relax";
    String EXCURSION_TYPE = "type.excursion";

    String POSITIVE_ANSWER = "y";
    String NEGATIVE_ANSWER = "n";
    String DOUBLE_DOT = ":";
    String DASH = "-";
    String COMMA = ",";
    String CURRENCY = "$";
    String FIRST_VARIANT = "1";
    String SECOND_VARIANT = "2";
    String THIRD_VARIANT = "3";
    String FOURTH_VARIANT = "4";
    String FIFTH_VARIANT = "5";
    String DIGITS_REGEX = "[0-9]{1,2}";
    String[] VARIANTS = {FIRST_VARIANT, SECOND_VARIANT, THIRD_VARIANT, FOURTH_VARIANT, FIFTH_VARIANT};

    String ANTALYA = "destination.antalya";
    String HURGHADA = "destination.hurghada";
    String ATHENS = "destination.athens";
    String VIENNA = "destination.vienna";
    String ROME = "destination.rome";

    String MEDITERRANEAN = "sea.mediterranean";
    String RED = "sea.red";
    String AEGEAN = "sea.aegean";

    String SIGHTSEEING = "excursion.sightseeing";
    String VIENNA_OPERA = "excursion.viennaopera";
    String COLISEUM = "excursion.coliseum";

    String NOT_PROVIDED = "feeding.notprovided";
    String ONLY_BREAKFAST = "feeding.onlybreakfast";
    String THREE_TIMES = "feeding.threetimes";
    String ALL_INCLUSIVE = "feeding.allinclusive";

    String BUS = "transport.bus";
    String SHIP = "transport.ship";
    String PLANE = "transport.plane";
    String TRAIN = "transport.train";

    Integer DAYS_MAXIMUM = 30;
    Integer FLOOR = 0;

}