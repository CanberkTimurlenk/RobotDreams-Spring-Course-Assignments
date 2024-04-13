package com.robotdreams.assignment7.repository;

import com.robotdreams.assignment7.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User,Long> {

}
