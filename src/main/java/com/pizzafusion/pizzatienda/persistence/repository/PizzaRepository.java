package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, String> {
}
