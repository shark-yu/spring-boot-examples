package com.shark.mybatis.service.impl;

import com.shark.mybatis.domain.Product;
import com.shark.mybatis.mapper.ProductMapper;
import com.shark.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAll() {
        return productMapper.findAll();
    }

    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    public void save(Product product) {
        productMapper.insert(product);
    }

    public void update(Product product) {
        productMapper.update(product);
    }

    public void delete(Long id) {
        productMapper.delete(id);
    }
}
