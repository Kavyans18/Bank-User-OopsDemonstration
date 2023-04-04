package com.pws.BankUseroopsDemonstration.service;

import com.pws.BankUseroopsDemonstration.entity.Bank;
import com.pws.BankUseroopsDemonstration.entity.User;

import java.util.List;

abstract class ServiceAbstractClass {

    abstract User display(int id);
    abstract List<User> display();


}
