package com.hrbu.java3.dao;

import com.hrbu.java3.vo.User;

import java.util.List;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 5:20
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public boolean isUser(String username, String password) {
        List<User> lists = search(User.class, "select * from user where name = ? and password = ?", username, password);
        return lists.size() > 0;
    }
}
