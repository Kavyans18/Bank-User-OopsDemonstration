package com.pws.BankUseroopsDemonstration.service;

import com.pws.BankUseroopsDemonstration.entity.Bank;
import com.pws.BankUseroopsDemonstration.entity.User;
import com.pws.BankUseroopsDemonstration.exception.IdNotFoundException;
import com.pws.BankUseroopsDemonstration.exception.NoDataAvailableException;
import com.pws.BankUseroopsDemonstration.repository.BankRepository;
import com.pws.BankUseroopsDemonstration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp extends ServiceAbstractClass implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    BankRepository bankRepository;

    @Override
    public User saveUser(User user, int bankId) {
        Optional<Bank> optional = bankRepository.findById(bankId);
        if(optional.isEmpty()){
            throw new IdNotFoundException("BANK ID NOT FOUND");
        }
        user.setBank(optional.get());
        repository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("INVALID USER ID");
        }
        User u = optional.get();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setAddress(user.getAddress());
        return repository.save(u);
    }

    @Override
    public User display(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("INVALID USER ID");
        }
        return optional.get();
    }

    @Override
    public List<User> display() {
        List<User> user = repository.findAll();
        if(user == null) {
            throw new NoDataAvailableException("USER LIST HAS NO DATA AVAILABLE");
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()){
            throw new IdNotFoundException("INVALID USER ID");
        }
        repository.delete(optional.get());
    }
}
