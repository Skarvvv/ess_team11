package com.team11.service;

import com.team11.dao.UserDao;
import com.team11.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao dao;

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public User selectOne(String account){
        return dao.selectOne(account);
    }

}
