package org.anticentro.spring.restfulwebservices.users;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Darth Vader", new Date()));
        users.add(new User(2, "Luck Skywalker", new Date()));
        users.add(new User(3, "R2D2", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findByOne(int id){
        for(User user:users)
            if(user.getId() == id) return user;
        return null;
    }

    public User deleteByOne(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
