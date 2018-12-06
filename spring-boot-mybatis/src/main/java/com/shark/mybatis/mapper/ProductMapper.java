package com.shark.mybatis.mapper;

import com.shark.mybatis.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

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
     * 插入产品
     * @param product
     */
    void insert(Product product);

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
