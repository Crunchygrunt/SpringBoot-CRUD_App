package com.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapi.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
