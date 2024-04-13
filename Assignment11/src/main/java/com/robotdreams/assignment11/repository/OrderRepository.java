package com.robotdreams.assignment11.repository;

import com.robotdreams.assignment11.entity.Order;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {
}
