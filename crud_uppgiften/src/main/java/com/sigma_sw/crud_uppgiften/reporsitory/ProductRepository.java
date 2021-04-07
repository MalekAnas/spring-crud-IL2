package com.sigma_sw.crud_uppgiften.reporsitory;


import com.sigma_sw.crud_uppgiften.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long > {




}
