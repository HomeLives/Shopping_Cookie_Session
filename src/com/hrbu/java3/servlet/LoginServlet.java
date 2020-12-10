package com.hrbu.java3.servlet;

import com.hrbu.java3.dao.ProductDao;
import com.hrbu.java3.dao.ProductDaoImpl;
import com.hrbu.java3.service.LoginService;
import com.hrbu.java3.service.LoginServiceImpl;
import com.hrbu.java3.vo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 3:09
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginServiceImpl login = new LoginServiceImpl();
        boolean flag = login.isUser(username, password);
        if (flag) {
            HttpSession session = request.getSession();
            /*将用户名存入session中*/
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + "/cart.jsp");
        } else {
            request.setAttribute("msg", "账号或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
