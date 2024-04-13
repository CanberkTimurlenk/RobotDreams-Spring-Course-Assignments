package com.robotdreams.assignment8.repository;


import com.robotdreams.assignment8.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {

}