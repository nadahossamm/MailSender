package com.example.newone.controller;

import com.example.newone.domain.User;
import com.example.newone.services.EmailService;
import com.example.newone.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private UserServices  userServices;

    @Autowired
    private EmailService emailService;

    @GetMapping("/user")
    List<User> list()
    {
            return  userServices.ListAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable int id) {
        try {
            User user = userServices.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);

}
        catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/getemail/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        try {
            User user = userServices.getByEmail(email);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/getIdbyEmail/{email}")
    public ResponseEntity<Integer> getIdByEmail(@PathVariable String email) {
        try {
            User user = userServices.getByEmail(email);

            return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/user")
    public void add(@RequestBody User user) {
        userServices.save(user);
      String vf=emailService.sendMail(user.getEmail(),user.getUsername());
        System.out.println("VF Is "+vf);
        user.setVerification(vf);
        user.setIsenabled(false);
        userServices.save(user);

    }
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Integer id) {
        userServices.delete(id);
    }
    @PutMapping("/user/updateAll/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            user.setId(id);
            userServices.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/user/updateName/{id}/{name}")
    public ResponseEntity<?> updateUsername( @PathVariable Integer id,@ PathVariable String name)
    {
        try {
          User user= userServices.get(id);
          user.setUsername(name);
            userServices.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 @PutMapping("/user/updatePass/{id}/{pass}")
    public ResponseEntity<?> updatePassword( @PathVariable Integer id,@ PathVariable String pass)
    {
        try {
          User user= userServices.get(id);
          user.setPassword(pass);
            userServices.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


 @PutMapping("/user/updateEmail/{id}/{pass}")
    public ResponseEntity<?> updateEmail( @PathVariable Integer id,@ PathVariable String email)
    {
        try {
          User user= userServices.get(id);
          user.setPassword(email);
            userServices.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
