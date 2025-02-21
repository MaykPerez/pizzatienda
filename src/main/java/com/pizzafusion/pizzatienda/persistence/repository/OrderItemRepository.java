package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.OrderItemEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


public interface OrderItemRepository extends ListCrudRepository<OrderItemEntity, String> {

}
