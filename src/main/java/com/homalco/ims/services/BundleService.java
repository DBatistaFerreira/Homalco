package com.homalco.ims.services;

import com.homalco.ims.entities.Bundle;

public interface BundleService {
    Bundle saveProduct(Bundle bundle);

    void deleteBundle(long id);

    Bundle getBundlle(long id);
}
