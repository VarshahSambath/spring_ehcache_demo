package com.demo.cache.loader;

import com.demo.cache.model.Users;
import com.demo.cache.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    public void load() {
        List<Users> usersList = getList();
        usersRepository.save(usersList);
    }

    public List<Users> getList() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("user1"));
        usersList.add(new Users("user2"));
        usersList.add(new Users("user3"));
        usersList.add(new Users("user4"));
        usersList.add(new Users("user5"));
        usersList.add(new Users("user6"));
        usersList.add(new Users("user7"));
        
        return usersList;
    }
}
