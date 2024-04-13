package com.robotdreams.assignment10.repository;


import com.robotdreams.assignment10.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {

}