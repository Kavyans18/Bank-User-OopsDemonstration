package com.pws.BankUseroopsDemonstration.service;

import com.pws.BankUseroopsDemonstration.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user, int bankId);
    User updateUser(User user, int id);
    void deleteUser(int id);
}
