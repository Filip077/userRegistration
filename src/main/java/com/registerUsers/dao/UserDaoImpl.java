package com.registerUsers.dao;

import com.registerUsers.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;



@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public void save(User newUser) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(newUser);
    }
}
