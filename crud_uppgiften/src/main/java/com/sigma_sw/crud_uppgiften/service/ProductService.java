package com.sigma_sw.crud_uppgiften.service;



import com.sigma_sw.crud_uppgiften.model.product.Product;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequestModel requestModel);
    ProductResponseModel getProductById(long id);
    List<Product> getAllProducts();
    ProductResponseModel updateProduct(String productId);
    ProductResponseModel deleteProduct(String productId);



}
