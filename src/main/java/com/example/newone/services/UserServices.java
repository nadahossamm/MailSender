package com.example.newone.services;

import com.example.newone.domain.User;
import com.example.newone.reposatory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> ListAll()
    {
        return  userRepository.findAll();
    }
    public  void save(User user)
    {
        userRepository.save(user);
    }
    public User get(int id) {
        return userRepository.findById(id).get();
    }
    public  void delete(Integer id)
    {
        userRepository.deleteById(id);
    }
    public  User getByEmail(String email)
    {
        return userRepository.getByEmail(email);
    }

}
