package controller;

/**
 * Interface, that contains regular expressions for checking inserted name, surname, login
 * @author Illia Korchan
 * @version 2.1.1
 */
public interface RegexContainer {
    String NAME_SURNAME_REGEX = "name.surname.regex";
    String LOGIN_REGEX = "[A-Za-z0-9_@]{8,20}";
}

