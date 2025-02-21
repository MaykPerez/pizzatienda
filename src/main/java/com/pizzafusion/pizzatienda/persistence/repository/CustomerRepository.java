package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.CustomerEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {


    @Modifying
    @Query(value="UPDATE customer c SET c.email= :email WHERE c.id_customer= :id", nativeQuery = true)
    void updateEmailCustomer(@Param("email") String email, @Param("id") String id);
}
