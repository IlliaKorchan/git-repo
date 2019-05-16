package com.company.model.dao.impl;

import com.company.model.dao.NoteBookDao;
import com.company.model.entity.NoteBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCNotebookDao implements NoteBookDao {
    private Connection connection;

    JDBCNotebookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(NoteBook noteBook) {
        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO registered_login(user_name , user_login)" +
                        " VALUES (? ,? )")){
            ps.setString(1 , noteBook.getFirstName());
            ps.setString(2 ,noteBook.getLoginData());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NoteBook findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM registered_login WHERE id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private NoteBook extractFromResultSet(ResultSet rs)
            throws SQLException {
        NoteBook result = new NoteBook();
        result.setId(rs.getInt("id") );
        result.setFirstName( rs.getString("user_name") );
        result.setLoginData( rs.getString("user_login"));
        return result;
    }

    @Override
    public List<NoteBook> findAll() {
        List<NoteBook> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery("SELECT * FROM registered_login");

            while ( rs.next() ){
                NoteBook result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void update(NoteBook noteBook) {
        try (PreparedStatement ps = connection.prepareStatement(
            "UPDATE registered_login SET user_name = ? , user_login = ?  " +
                    "WHERE id = ?")){
            ps.setString(1 , noteBook.getFirstName());
            ps.setString(2 ,noteBook.getLoginData());
            ps.setInt(3, noteBook.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM registered_login  WHERE id = ?")){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
