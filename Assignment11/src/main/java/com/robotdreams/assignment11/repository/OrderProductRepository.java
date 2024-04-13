package com.robotdreams.assignment11.repository;

import com.robotdreams.assignment11.entity.OrderProduct;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends ListCrudRepository<OrderProduct, Long> {

}
