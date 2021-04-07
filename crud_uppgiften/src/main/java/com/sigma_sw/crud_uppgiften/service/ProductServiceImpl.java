package com.sigma_sw.crud_uppgiften.service;


import com.sigma_sw.crud_uppgiften.model.product.Product;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;
import com.sigma_sw.crud_uppgiften.model.shared.ProductDto;
import com.sigma_sw.crud_uppgiften.reporsitory.ProductRepository;
import com.sigma_sw.crud_uppgiften.utils.UIDGenerator;
import org.apache.commons.beanutils.BeanUtilsBean;
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
    public ProductResponseModel addProduct(ProductRequestModel productRequestModel) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(uidGenerator.generateUID(30));
        BeanUtils.copyProperties(productRequestModel, productDto);
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productRepository.save(product);
        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(product, response);
        return response;
    }

    @Override
    public ProductResponseModel getProductById(String publicID) {
        Product product=  productRepository.getProductByProductId(publicID);
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
