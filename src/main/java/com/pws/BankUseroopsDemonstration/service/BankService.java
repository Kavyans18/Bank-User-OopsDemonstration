package com.pws.BankUseroopsDemonstration.service;

import com.pws.BankUseroopsDemonstration.entity.Bank;

import java.util.List;

public interface BankService {

    Bank saveBank(Bank bank);
    Bank updateBank(Bank bank, int id);
    Bank getBankById(int id);
    List<Bank> getAll();
    default Bank deleteBank(int id){
        return null;
    }
}
