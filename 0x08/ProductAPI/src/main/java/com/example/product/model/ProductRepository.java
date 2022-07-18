package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return this.list;
    }

    public Product getProductById(Long id) {
        for (Product product: list) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product s) {
        this.list.add(s);
    }

    public void updateProduct(Product s) {
        for (Product product: list) {
            if (product.getId().equals(s.getId())) {
                product.setName(s.getName());
                product.setCode(s.getCode());
                product.setCreatedOne(s.getCreatedOne());
                product.setDescription(s.getDescription());
                product.setPrice(s.getPrice());
                product.setStatus(s.isStatus());
                break;
            }
        }
    }

    public void removeProduct(Product s) {
        this.list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        this.list.addAll(listOfProducts);
    }
}
