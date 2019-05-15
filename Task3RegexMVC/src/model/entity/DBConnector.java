package model.entity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static view.GlobalConstants.*;

/**
 * Class for connecting to database
 * @author Illia Korchan
 * @version 2.1
 */
public class DBConnector {
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ACCOUNTS_QUERY)) {
            ResultSet results = statement.executeQuery();

            while(results.next()) {
                String name = results.getString(1);
                String login = results.getString(2);

                accounts.add(new Account(name, login));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_DB, LOGIN_DB, PASSWORD_DB);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
