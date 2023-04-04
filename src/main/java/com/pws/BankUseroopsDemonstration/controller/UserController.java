package com.pws.BankUseroopsDemonstration.controller;

import com.pws.BankUseroopsDemonstration.entity.User;
import com.pws.BankUseroopsDemonstration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/save/{bankId}")
    public ResponseEntity<User> saveUser(@RequestBody User user, @PathVariable int bankId) {
        service.saveUser(user, bankId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
        service.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User u =service.display(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
       List<User> user =  service.display();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
