package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.domain.Departs;
import com.example.demo.domain.Staffs;

public interface StaffService {

	<S extends Staffs> List<S> findAll(Example<S> example, Sort sort);

	<S extends Staffs> List<S> findAll(Example<S> example);

	Staffs getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Staffs> entities);

	Staffs getOne(String id);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Staffs entity);

	void deleteById(String id);

	long count();

	<S extends Staffs> boolean exists(Example<S> example);

	<S extends Staffs> long count(Example<S> example);

	<S extends Staffs> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Staffs> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Staffs> S saveAndFlush(S entity);

	void flush();

	<S extends Staffs> List<S> saveAll(Iterable<S> entities);

	Optional<Staffs> findById(String id);

	List<Staffs> findAllById(Iterable<String> ids);

	List<Staffs> findAll(Sort sort);

	List<Staffs> findAll();

	Page<Staffs> findAll(Pageable pageable);

	<S extends Staffs> Optional<S> findOne(Example<S> example);

	<S extends Staffs> S save(S entity);

	List<Departs> findAllDeparts();

	List<Staffs> findByNameContaining(String name);

	Page<Staffs> findByNameContaining(String name, Pageable pageable);

	

}
