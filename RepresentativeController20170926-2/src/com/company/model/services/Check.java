package com.company.model.services;

import com.company.model.entity.NotUniqueLoginException;

public interface Check {
    boolean checkLogin(String loginData) throws NotUniqueLoginException;
}
