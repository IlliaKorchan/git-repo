package model.entity;

public class Account {
    private String name;
    private String login;

    public Account(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }
}
