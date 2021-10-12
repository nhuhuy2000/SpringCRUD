package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.domain.Departs;

public interface ServiceDepart {

	<S extends Departs> List<S> findAll(Example<S> example, Sort sort);

	<S extends Departs> List<S> findAll(Example<S> example);

	Departs getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Departs> entities);

	Departs getOne(String id);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Departs entity);

	void deleteById(String id);

	long count();

	<S extends Departs> boolean exists(Example<S> example);

	<S extends Departs> long count(Example<S> example);

	<S extends Departs> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Departs> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Departs> S saveAndFlush(S entity);

	void flush();

	<S extends Departs> List<S> saveAll(Iterable<S> entities);

	Optional<Departs> findById(String id);

	List<Departs> findAllById(Iterable<String> ids);

	List<Departs> findAll(Sort sort);

	List<Departs> findAll();

	Page<Departs> findAll(Pageable pageable);

	<S extends Departs> Optional<S> findOne(Example<S> example);

	<S extends Departs> S save(S entity);

}
