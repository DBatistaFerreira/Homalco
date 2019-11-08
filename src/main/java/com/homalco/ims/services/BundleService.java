package com.homalco.ims.services;

import com.homalco.ims.entities.Bundle;
import com.homalco.ims.repositories.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BundleService {

    private BundleRepository bundleRepository;

    @Autowired
    public BundleService(BundleRepository bundleRepository){
        this.bundleRepository = bundleRepository;
    }

    public Bundle saveProduct(Bundle bundle){
        return bundleRepository.save(bundle);
    }

    public void deleteBundle(long id){
        bundleRepository.delete(bundleRepository.getOne(id));
    }

    public Bundle getBundlle(long id){
        return bundleRepository.getOne(id);
    }
}
