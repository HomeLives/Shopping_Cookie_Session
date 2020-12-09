package com.hrbu.java3.dao;

import com.hrbu.java3.vo.Product;

import java.util.List;

/**
 * @Author Frank
 * @Date: 2020/12/9 0009 下午 6:02
 */
public interface ProductDao {
    /**
     * 查找所有商品
     *
     * @return
     */
    List<Product> getAll();
}
