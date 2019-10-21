package com.demo.cache.cache;

import com.demo.cache.model.Users;
import com.demo.cache.repository.UsersRepository;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersCache {

    @Autowired
    UsersRepository usersRepository;

    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name) {
        System.out.println("Retrieving from Database for name: " + name);
        StopWatch watch = new StopWatch();
        watch.start();
        
        Users users=usersRepository.findByName(name);
        
		watch.stop();
		System.out.println("Time Elapsed: " + watch.getTime());
        return users;
    }
}
 