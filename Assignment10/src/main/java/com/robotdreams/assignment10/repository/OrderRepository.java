package com.robotdreams.assignment10.repository;

import com.robotdreams.assignment10.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Long> {
}
