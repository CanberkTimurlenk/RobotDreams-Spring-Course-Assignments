package com.robotdreams.assignment11.repository;


import com.robotdreams.assignment11.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {

}