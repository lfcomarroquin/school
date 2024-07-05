package com.api.school.service;

import com.api.school.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private Map<Long, ProductDto> list = new HashMap<Long, ProductDto>();
    private Long id = 1L;

    public List<ProductDto> getAllProducts() {
        return new ArrayList<ProductDto>(list.values());
    }

    public ProductDto getProductById(Long id) {
        return list.get(id);
    }

    public ProductDto save(ProductDto product) {
        product.setId(id);
        list.put(product.getId(), product);
        id++;
        return product;
    }

    public ProductDto update(ProductDto product, Long id) {
        if (list.containsKey(id)) {
            product.setId(id);
            list.put(product.getId(), product);
            return product;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        list.remove(id);
    }

}