package com.pws.BankUseroopsDemonstration.service;

import com.pws.BankUseroopsDemonstration.entity.Bank;
import com.pws.BankUseroopsDemonstration.exception.IdNotFoundException;
import com.pws.BankUseroopsDemonstration.exception.NoDataAvailableException;
import com.pws.BankUseroopsDemonstration.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImp implements BankService {
    @Autowired
    BankRepository repository;

    @Override
    public Bank saveBank(Bank bank){
        return repository.save(bank);
    }

    @Override
    public Bank updateBank(Bank bank, int id){
        Optional<Bank> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new IdNotFoundException("INVALID BANK ID");
        }
        Bank b = optional.get();
        b.setName(bank.getName());
        b.setEmail(bank.getEmail());
        b.setAddress(bank.getAddress());
        b.setPhoneNumber(bank.getPhoneNumber());
        b.setUser(bank.getUser());
        repository.save(b);
        return b;
    }

    @Override
    public Bank getBankById(int id) {
        Optional<Bank> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("INVALID BANK ID");
        }
        return optional.get();
    }

    public List<Bank> getAll(){
        List<Bank> bank = repository.findAll();
        if(bank == null){
        throw new NoDataAvailableException("Bank list is empty");
        }
        return bank;
    }

    @Override
    public Bank deleteBank(int id){
        Optional<Bank> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("INVALID BANK ID");
        }
        repository.delete(optional.get());
        return optional.get();
    }
}
