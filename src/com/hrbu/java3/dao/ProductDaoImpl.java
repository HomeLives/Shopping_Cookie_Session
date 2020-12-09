package com.hrbu.java3.dao;

import com.hrbu.java3.vo.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 6:03
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public List<Product> getAll() {
        List<Product> list = search(Product.class, "select * from product");
        return list;
    }
}
