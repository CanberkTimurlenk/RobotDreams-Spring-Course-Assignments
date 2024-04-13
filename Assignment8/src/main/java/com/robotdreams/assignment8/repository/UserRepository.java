package com.robotdreams.assignment8.repository;

import com.robotdreams.assignment8.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User,Long> {

}
