package com.sigma_sw.crud_uppgiften.service;


import com.sigma_sw.crud_uppgiften.model.product.Product;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;
import com.sigma_sw.crud_uppgiften.model.shared.ProductDto;
import com.sigma_sw.crud_uppgiften.reporsitory.ProductRepository;
import com.sigma_sw.crud_uppgiften.utils.UIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


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
        Product product = productRepository.getProductByProductId(publicID);
        if (product == null)
            return null;
        ProductResponseModel returnValue = new ProductResponseModel();
        BeanUtils.copyProperties(product, returnValue);
        return returnValue;
    }

    @Override
    public List<ProductResponseModel> getAllProducts() {


        List<Product> products = productRepository.findAll();

        List<ProductResponseModel> returnList = products.stream().map(product -> {
            ProductResponseModel responseModel = new ProductResponseModel();
            BeanUtils.copyProperties(product, responseModel);
            return responseModel;
        }).collect(Collectors.toList());

        return returnList;

    }

    @Override
    public ProductResponseModel updateProduct(String id, ProductRequestModel productRequestModel) {
        Product productToUpdate = productRepository.getProductByProductId(id);


        if (productToUpdate == null) {
            return null;
        }


        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productRequestModel, productDto);
        productDto.setProductId(productToUpdate.getProductId());
        productDto.setId(productToUpdate.getId());


        ProductResponseModel productResponseModel = new ProductResponseModel();

        BeanUtils.copyProperties(productDto, productToUpdate);
        productRepository.save(productToUpdate);
        BeanUtils.copyProperties(productToUpdate, productResponseModel);

        return productResponseModel;
    }


    @Override
    public ProductResponseModel deleteProduct(String productId) {
        return null;
    }


}
