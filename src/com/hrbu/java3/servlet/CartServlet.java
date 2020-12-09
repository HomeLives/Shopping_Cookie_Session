package com.hrbu.java3.servlet;

import com.hrbu.java3.dao.ProductDao;
import com.hrbu.java3.dao.ProductDaoImpl;
import com.hrbu.java3.vo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 5:48
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
    private List<Product> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            List<Product> products = (List<Product>) session.getAttribute("products");
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDao pro = new ProductDaoImpl();
            List<Product> list = null;
            Product product = null;
            if (products == null) {
                product = pro.getById(id);
                list = new ArrayList<>();
                list.add(product);
            } else {
                product = pro.getById(id);
                list = (List<Product>) session.getAttribute("products");
                list.add(product);
            }
            session.setAttribute("products", list);
            list = (List<Product>) session.getAttribute("products");
            /*System.out.println(list);*/
            response.sendRedirect(request.getContextPath() + "/cart.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
