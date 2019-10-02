package com.borodich.dao.api;

import com.borodich.entity.Product;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao extends BaseDao<Product> {
    public List<Product> getProductsFromSection(String titleSection);

}
