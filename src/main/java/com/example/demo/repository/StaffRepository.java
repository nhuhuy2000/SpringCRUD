package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Staffs;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, String> {
	List<Staffs> findByNameContaining(String name);
	Page<Staffs> findByNameContaining(String name, Pageable pageable);
}
