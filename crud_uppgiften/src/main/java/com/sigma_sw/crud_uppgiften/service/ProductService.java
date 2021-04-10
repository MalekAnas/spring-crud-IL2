package com.sigma_sw.crud_uppgiften.service;



import com.sigma_sw.crud_uppgiften.model.product.Product;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;
import com.sigma_sw.crud_uppgiften.model.shared.ProductDto;

import java.util.List;

public interface ProductService {

    ProductResponseModel addProduct(ProductRequestModel requestModel);
    ProductResponseModel getProductById(String id);
    List<ProductResponseModel> getAllProducts();
    ProductResponseModel updateProduct(String productId ,ProductRequestModel productRequestModel);
    ProductResponseModel deleteProduct(String productId);




}
