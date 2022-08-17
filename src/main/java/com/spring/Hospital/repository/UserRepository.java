package com.spring.Hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.Hospital.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	List<User> findAll();
}