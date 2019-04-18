package controller;

import model.Notebook;
import model.entity.ExistingAccountsDB;
import model.entity.LoginAlreadyExistsException;
import view.GlobalConstants;
import view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class, that checks input data and process registration
 * @author Illia Korchan
 * @version 2.1.1
 */
public class Controller implements GlobalConstants, RegexContainer {
    View view;
    Scanner in = new Scanner(System.in);
    private static String MESSAGE_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle;

    /**
     * Constructor with no params, creates new object
     */
    public Controller() {
    }

    /**
     * Constructor with param view, creates new object
     * @param view - object of View class
     */
    public Controller(View view) {
        this.view = view;
    }

    /**
     * Method, that controls registration process
     */
    public void processUser() {
        setLanguage();

        String userName = input(view.createMessage(bundle.getString(INPUT_MESSAGE), bundle.getString(NAME), DOUBLE_DOT),
                                bundle.getString(NAME_SURNAME_REGEX),
                                view.createMessage(bundle.getString(INCORRECT_INPUT_MESSAGE),
                                                   bundle.getString(NAME_SURNAME_SYMBOLS_ALLOWED))
                               );
        String userSurname = input(view.createMessage(bundle.getString(INPUT_MESSAGE), bundle.getString(SURNAME), DOUBLE_DOT),
                                   bundle.getString(NAME_SURNAME_REGEX),
                                   view.createMessage(bundle.getString(INCORRECT_INPUT_MESSAGE),
                                                      bundle.getString(NAME_SURNAME_SYMBOLS_ALLOWED))
                                  );
        String userLogin = input(view.createMessage(bundle.getString(INPUT_MESSAGE), bundle.getString(LOGIN), DOUBLE_DOT),
                                 LOGIN_REGEX,
                                 view.createMessage(bundle.getString(INCORRECT_INPUT_MESSAGE),
                                                    bundle.getString(LOGIN_SYMBOLS_ALLOWED))
                                );

        Notebook newUser = new Notebook(userName, userSurname, userLogin);
        view.printMessages(bundle.getString(THANKYOU_MESSAGE),
                           view.createMessage(bundle.getString(OUTPUT_MESSAGE), DOUBLE_DOT),
                           view.createMessage(bundle.getString(NAME), DOUBLE_DOT, newUser.getName()),
                           view.createMessage(bundle.getString(SURNAME), DOUBLE_DOT,newUser.getSurname()),
                           view.createMessage(bundle.getString(LOGIN), DOUBLE_DOT, newUser.getLogin())
                           );
    }

    /**
     * Method for inserting correct registration data: name, surname and login
     * @param inputMessage - inserted data, that must be checked
     * @param regex - regex to compare with inserted data
     * @param incorrectInput - message, that will be displayed in case of incorrect inserting
     * @return inserted data
     */
    public String input(String inputMessage, String regex, String incorrectInput) {
        for(;;) {
            view.printMessages(inputMessage);
            String valueToCheck = in.nextLine();
            if (checkValidation(valueToCheck, regex)) {
                if (inputMessage.contains(bundle.getString(LOGIN))) {
                    try {
                        ExistingAccountsDB.checkForExistence(valueToCheck);
                    } catch (LoginAlreadyExistsException e) {
                        view.printMessages(view.createMessage(bundle.getString(LOGIN),
                                                              valueToCheck,
                                                              bundle.getString(LOGIN_ALREADY_EXISTS_MESSAGE))
                                          );
                        continue;
                    }
                }
                view.printMessages(bundle.getString(CORRECT_INPUT_MESSAGE));
                return valueToCheck;
            } else {
                view.printMessages(incorrectInput);
                continue;
            }
        }
    }

    /**
     * Method, that checks correct inserting of data
     * @param stringToCheck - data, that must be checked
     * @param regex - regex, that must be compared to inserted data
     * @return is data correct or not
     */
    public boolean checkValidation(String stringToCheck, String regex) {
        if (stringToCheck.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method, that asking user if he wants to change language
     * @return user`s answer
     */
    public void setLanguage() {
        for(;;) {
            view.printMessages(CHANGE_LANGUAGE_MESSAGE);
            String change = in.nextLine();
            if(change.equalsIgnoreCase("y")) {
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, new Locale("uk", "UA"));
                return;
            } else if (change.equalsIgnoreCase("n")) {
                bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,new Locale("", ""));
                return;
            } else {
                view.printMessages(INCORRECT_ANSWER);
                continue;
            }
        }
    }
}
