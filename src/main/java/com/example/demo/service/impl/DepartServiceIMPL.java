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
import com.example.demo.repository.DepartRepository;
import com.example.demo.service.ServiceDepart;
@Service
public class DepartServiceIMPL implements ServiceDepart{
		@Autowired
		DepartRepository departRepository;

		@Override
		public <S extends Departs> S save(S entity) {
			return departRepository.save(entity);
		}

		@Override
		public <S extends Departs> Optional<S> findOne(Example<S> example) {
			return departRepository.findOne(example);
		}

		@Override
		public Page<Departs> findAll(Pageable pageable) {
			return departRepository.findAll(pageable);
		}

		@Override
		public List<Departs> findAll() {
			return departRepository.findAll();
		}

		@Override
		public List<Departs> findAll(Sort sort) {
			return departRepository.findAll(sort);
		}

		@Override
		public List<Departs> findAllById(Iterable<String> ids) {
			return departRepository.findAllById(ids);
		}

		@Override
		public Optional<Departs> findById(String id) {
			return departRepository.findById(id);
		}

		@Override
		public <S extends Departs> List<S> saveAll(Iterable<S> entities) {
			return departRepository.saveAll(entities);
		}

		@Override
		public void flush() {
			departRepository.flush();
		}

		@Override
		public <S extends Departs> S saveAndFlush(S entity) {
			return departRepository.saveAndFlush(entity);
		}

		@Override
		public boolean existsById(String id) {
			return departRepository.existsById(id);
		}

		@Override
		public <S extends Departs> List<S> saveAllAndFlush(Iterable<S> entities) {
			return departRepository.saveAllAndFlush(entities);
		}

		@Override
		public <S extends Departs> Page<S> findAll(Example<S> example, Pageable pageable) {
			return departRepository.findAll(example, pageable);
		}

		@Override
		public <S extends Departs> long count(Example<S> example) {
			return departRepository.count(example);
		}

		@Override
		public <S extends Departs> boolean exists(Example<S> example) {
			return departRepository.exists(example);
		}

		@Override
		public long count() {
			return departRepository.count();
		}

		@Override
		public void deleteById(String id) {
			departRepository.deleteById(id);
		}

		@Override
		public void delete(Departs entity) {
			departRepository.delete(entity);
		}

		@Override
		public void deleteAllById(Iterable<? extends String> ids) {
			departRepository.deleteAllById(ids);
		}

		@Override
		public Departs getOne(String id) {
			return departRepository.getOne(id);
		}

		@Override
		public void deleteAll(Iterable<? extends Departs> entities) {
			departRepository.deleteAll(entities);
		}

		@Override
		public void deleteAll() {
			departRepository.deleteAll();
		}

		@Override
		public Departs getById(String id) {
			return departRepository.getById(id);
		}

		@Override
		public <S extends Departs> List<S> findAll(Example<S> example) {
			return departRepository.findAll(example);
		}

		@Override
		public <S extends Departs> List<S> findAll(Example<S> example, Sort sort) {
			return departRepository.findAll(example, sort);
		}
		
}
