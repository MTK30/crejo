package com.company.services;

import com.company.models.User;
import com.company.utils.Const;

public class UserService {

    public static User addUser(String name) {
        User user = new User();
        user.setName(name.toLowerCase());
        Const.users.add(user);
        return user;
    }

    public static void printUsers() {
        for (User user : Const.users ){
            System.out.println(user);
        }
    }

    public static User getUserByName(String userName) {
        for (User user : Const.users ){
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
