package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, String> {

    @Modifying
    @Query(value="delete from pizza where id_pizza= :idpizza", nativeQuery = true)
    void deletePizza(@Param("idpizza")Integer id);
}
