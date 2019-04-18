package model;

/**
 * POJO class of registered users
 * @author Illia Korchan
 * @version 2.1.1
 */
public class Notebook {
    private String name;
    private String surname;
    private String login;

    /**
     * Constructor with no params, creates new object
     */
    public Notebook() {
    }

    /**
     * Constructor with params, creates new object
     * @param name - user`s name
     * @param surname - user`s surname
     * @param login - user`s login
     */
    public Notebook(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
