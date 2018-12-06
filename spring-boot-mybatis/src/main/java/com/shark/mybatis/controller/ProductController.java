package com.shark.mybatis.controller;

import com.shark.mybatis.core.ResponseResult;
import com.shark.mybatis.domain.Product;
import com.shark.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取产品列表
     * @return
     */
    @GetMapping(value = "/products")
    public ResponseResult getProducts() {
        List<Product> products = productService.findAll();
        return new ResponseResult(products);
    }

    /**
     * 获取产品详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "/products/{id}")
    public ResponseResult getDetails(@PathVariable Long id) {
        return new ResponseResult(productService.findById(id));
    }

    /**
     * 创建产品
     * @param product
     * @return
     */
    @PostMapping(value = "/products")
    public String add(@RequestBody Product product) {
        productService.save(product);
        return "success";
    }

    /**
     * 更新产品
     * @param id
     * @param product
     * @return
     */
    @PatchMapping(value = "/products/{id}")
    public String update(@PathVariable Long id, @RequestBody Product product) {
        productService.update(product);
        return "success";
    }

    /**
     * 删除产品
     * @param id
     * @return
     */
    @DeleteMapping(value = "/products/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "success";
    }
}
