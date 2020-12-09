package com.hrbu.java3.service;

import com.hrbu.java3.dao.UserDao;
import com.hrbu.java3.dao.UserDaoImpl;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 5:27
 */
public class LoginServiceImpl implements LoginService {

    private UserDaoImpl user = new UserDaoImpl();

    @Override
    public boolean isUser(String username, String password) {
        return user.isUser(username, password);
    }
}
