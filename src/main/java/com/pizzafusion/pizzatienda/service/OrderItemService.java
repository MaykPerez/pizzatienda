package com.pizzafusion.pizzatienda.service;

import com.pizzafusion.pizzatienda.persistence.model.OrderItemEntity;
import com.pizzafusion.pizzatienda.persistence.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    public final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrderItem(OrderItemEntity orderItemEntity){
        orderItemRepository.save(orderItemEntity);
    }
}
