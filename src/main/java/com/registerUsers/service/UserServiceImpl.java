package com.registerUsers.service;

import com.registerUsers.dao.UserDao;
import com.registerUsers.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao theUserDao){
        userDao = theUserDao;
    }



    @Override
    @Transactional
    public void save(User user) {
        user.setUnique_code(randomAlphaNumeric(10));
        userDao.save(user);
    }


    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
