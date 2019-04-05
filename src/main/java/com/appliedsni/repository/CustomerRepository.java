package com.appliedsni.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.appliedsni.model.CustomerEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
