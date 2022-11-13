package com.dcfin.mf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dcfin.mf.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
