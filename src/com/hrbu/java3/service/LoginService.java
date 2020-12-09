package com.hrbu.java3.service;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 5:26
 */
public interface LoginService {
    /**
     * 判断用户登录是否成功
     *
     * @param username
     * @param password
     * @return
     */
    boolean isUser(String username, String password);
}
