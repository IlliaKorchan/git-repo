package com.company.model.services;

import com.company.model.dao.impl.JDBCDaoFactory;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;

import java.util.List;

public class Checker implements Check {
    public boolean checkLogin(String loginData) throws NotUniqueLoginException {
        List<NoteBook> registeredLogins = JDBCDaoFactory.getInstance().createNoteBookDao().findAll();
        if (registeredLogins.stream().anyMatch(n -> n.getLoginData().equals(loginData))) {
            throw new NotUniqueLoginException("Not unique login: ", loginData);
        }
        return true;
    }
}
