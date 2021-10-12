package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

public interface UserService {

	<S extends User> List<S> findAll(Example<S> example, Sort sort);

	<S extends User> List<S> findAll(Example<S> example);

	User getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends User> entities);

	User getOne(String id);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(User entity);

	void deleteById(String id);

	long count();

	<S extends User> boolean exists(Example<S> example);

	<S extends User> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends User> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends User> S saveAndFlush(S entity);

	void flush();

	<S extends User> List<S> saveAll(Iterable<S> entities);

	Optional<User> findById(String id);

	List<User> findAllById(Iterable<String> ids);

	List<User> findAll(Sort sort);

	List<User> findAll();

	Page<User> findAll(Pageable pageable);

	<S extends User> Optional<S> findOne(Example<S> example);

	<S extends User> S save(S entity);

	boolean checkLogin(String username, String password);
}
