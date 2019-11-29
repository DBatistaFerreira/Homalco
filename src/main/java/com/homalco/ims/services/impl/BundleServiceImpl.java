package com.homalco.ims.services.impl;

import com.homalco.ims.entities.Bundle;
import com.homalco.ims.repositories.BundleRepository;
import com.homalco.ims.services.BundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleServiceImpl implements BundleService {

    private BundleRepository bundleRepository;

    @Autowired
    public BundleServiceImpl(BundleRepository bundleRepository){
        this.bundleRepository = bundleRepository;
    }

    @Override public Bundle saveProduct(Bundle bundle){
        return bundleRepository.save(bundle);
    }

    @Override public void deleteBundle(long id){
        bundleRepository.delete(bundleRepository.getOne(id));
    }

    @Override public Bundle getBundlle(long id){
        return bundleRepository.getOne(id);
    }
}
