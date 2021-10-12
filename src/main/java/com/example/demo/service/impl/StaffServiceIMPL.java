package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Departs;
import com.example.demo.domain.Staffs;
import com.example.demo.repository.DepartRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;

@Service
public class StaffServiceIMPL implements StaffService{
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	DepartRepository departRepository;
	@Override
	public List<Staffs> findByNameContaining(String name) {
		return staffRepository.findByNameContaining(name);
	}
	@Override
	public List<Departs> findAllDeparts() {
		return departRepository.findAll();
	}
	@Override
	public Page<Staffs> findByNameContaining(String name, Pageable pageable) {
		return staffRepository.findByNameContaining(name, pageable);
	}
	@Override
	public <S extends Staffs> S save(S entity) {
		return staffRepository.save(entity);
	}

	@Override
	public <S extends Staffs> Optional<S> findOne(Example<S> example) {
		return staffRepository.findOne(example);
	}

	@Override
	public Page<Staffs> findAll(Pageable pageable) {
		return staffRepository.findAll(pageable);
	}

	@Override
	public List<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public List<Staffs> findAll(Sort sort) {
		return staffRepository.findAll(sort);
	}

	@Override
	public List<Staffs> findAllById(Iterable<String> ids) {
		return staffRepository.findAllById(ids);
	}

	@Override
	public Optional<Staffs> findById(String id) {
		return staffRepository.findById(id);
	}

	@Override
	public <S extends Staffs> List<S> saveAll(Iterable<S> entities) {
		return staffRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		staffRepository.flush();
	}

	@Override
	public <S extends Staffs> S saveAndFlush(S entity) {
		return staffRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return staffRepository.existsById(id);
	}

	@Override
	public <S extends Staffs> List<S> saveAllAndFlush(Iterable<S> entities) {
		return staffRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Staffs> Page<S> findAll(Example<S> example, Pageable pageable) {
		return staffRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Staffs> long count(Example<S> example) {
		return staffRepository.count(example);
	}

	@Override
	public <S extends Staffs> boolean exists(Example<S> example) {
		return staffRepository.exists(example);
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(String id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		staffRepository.deleteAllById(ids);
	}

	@Override
	public Staffs getOne(String id) {
		return staffRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}

	@Override
	public Staffs getById(String id) {
		return staffRepository.getById(id);
	}

	@Override
	public <S extends Staffs> List<S> findAll(Example<S> example) {
		return staffRepository.findAll(example);
	}

	@Override
	public <S extends Staffs> List<S> findAll(Example<S> example, Sort sort) {
		return staffRepository.findAll(example, sort);
	}
	
}
