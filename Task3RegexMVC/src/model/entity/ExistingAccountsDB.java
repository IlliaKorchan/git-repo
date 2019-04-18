package model.entity;

/**
 * Enumeration for created accounts
 * @author Illia Korchan
 * @version 2.1.1
 */
public enum ExistingAccountsDB {
    STEPAN("Степан", "Stepan55"), IVAN("Іван", "Ivan1234"), MYKOLA("Микола", "Nikolay1522");

    String name;
    String login;

    ExistingAccountsDB(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public static boolean checkForExistence(String login) throws LoginAlreadyExistsException {
        for (ExistingAccountsDB account : ExistingAccountsDB.values()) {
            if (account.login.equals(login)) {
                throw new LoginAlreadyExistsException();
            }
        }
        return true;
    }

    public String getLogin() {
        return login;
    }
}
