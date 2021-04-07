package com.sigma_sw.crud_uppgiften.service;


import com.sigma_sw.crud_uppgiften.model.product.Product;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;
import com.sigma_sw.crud_uppgiften.reporsitory.ProductRepository;
import com.sigma_sw.crud_uppgiften.utils.UIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UIDGenerator uidGenerator;

    @Override
    public Product addProduct(ProductRequestModel productRequestModel) {
        Product product = new Product();
        product.setProductId(uidGenerator.generateUID(30));
        BeanUtils.copyProperties(productRequestModel, product);
        return productRepository.save(product);
    }

    @Override
    public ProductResponseModel getProductById(long id) {



        Product product=  productRepository.findById(id).get();
        ProductResponseModel returnValue = new ProductResponseModel();

        BeanUtils.copyProperties(product, returnValue);

        return returnValue;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponseModel updateProduct(String productId) {
        return null;
    }

    @Override
    public ProductResponseModel deleteProduct(String productId) {
        return null;
    }
}
