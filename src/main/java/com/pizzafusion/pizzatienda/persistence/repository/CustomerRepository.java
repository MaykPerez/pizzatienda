package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {
}
