package com.crudapi.service.impl;

import com.crudapi.service.CloudVendorService;
import com.crudapi.model.CloudVendor;
import com.crudapi.repository.CloudVendorRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.crudapi.exception.CloudVendorNotFoundException;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
    
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor){
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor){
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor updated successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId){
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Cloud Vendor deleted successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId){
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested CloudVendor with ID: " + cloudVendorId + " does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorRepository.findAll();
    }
}
