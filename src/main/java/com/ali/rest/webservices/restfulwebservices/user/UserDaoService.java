package com.ali.rest.webservices.restfulwebservices.user;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static int usersCount=3;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"Ali",new Date()));
        users.add(new User(2,"Mehman",new Date()));
        users.add(new User(3,"Ehmed",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        if (user.getId()==null || user.getId()==0){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(Integer id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(Integer id){
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
