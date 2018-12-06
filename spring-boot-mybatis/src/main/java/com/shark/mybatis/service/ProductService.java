package com.shark.mybatis.service;

import com.shark.mybatis.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAll();

    /**
     * 根据ID查询产品
     * @param id
     * @return
     */
    Product findById(Long id);

    /**
     * 保存产品
     * @param product
     */
    void save(Product product);

    /**
     * 更新产品
     * @param product
     */
    void update(Product product);

    /**
     * 删除产品
     * @param id
     */
    void delete(Long id);
}
