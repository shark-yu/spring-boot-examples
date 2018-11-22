package com.shark.swagger2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    static Map<Long, Product> products = Collections.synchronizedMap(new HashMap<Long, Product>());

    @ApiOperation(value = "获取产品列表", notes = "")
    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        List<Product> r = new ArrayList<Product>(products.values());
        return r;
    }

    @ApiOperation(value = "创建产品", notes = "根据Product对象创建产品")
    @ApiImplicitParam(name = "product", value = "产品详细实体product", required = true, dataType = "Product")
    @PostMapping(value = "/products")
    public String addProduct(@RequestBody Product product) {
        products.put(product.getId(), product);
        return "success";
    }

    @ApiOperation(value = "获取产品详细信息", notes = "根据url的id来获取产品详细信息")
    @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
    @GetMapping(value = "/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return products.get(id);
    }

    @ApiOperation(value = "更新产品详细信息", notes = "根据url的id来指定更新对象，并根据传过来的product信息来更新产品详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "product", value = "产品详细实体product", required = true, dataType = "Product")
    })
    @PatchMapping(value = "/products/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product p = products.get(id);
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        products.put(id, p);
        return "success";
    }

    @ApiOperation(value = "删除产品", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "产品ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        products.remove(id);
        return "success";
    }

}
