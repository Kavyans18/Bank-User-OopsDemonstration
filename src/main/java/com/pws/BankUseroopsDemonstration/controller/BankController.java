package com.pws.BankUseroopsDemonstration.controller;

import com.pws.BankUseroopsDemonstration.entity.Bank;
import com.pws.BankUseroopsDemonstration.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/banks")
public class BankController {

    @Autowired
    BankService service;

    @PostMapping("/save")
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank) {
        service.saveBank(bank);
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bank> updateBank(@RequestBody Bank bank, @PathVariable int id) {
        service.updateBank(bank, id);
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Bank> display(@PathVariable int id) {
        Bank b = service.getBankById(id);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bank>> display() {
        List<Bank> bank = service.getAll();
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Bank> deleteBank(@PathVariable int id) {
        service.deleteBank(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
