package com.pizzafusion.pizzatienda.service;

import com.pizzafusion.pizzatienda.persistence.model.OrderEntity;
import com.pizzafusion.pizzatienda.persistence.model.OrderItemEntity;
import com.pizzafusion.pizzatienda.persistence.projection.OrderSummary;
import com.pizzafusion.pizzatienda.persistence.repository.OrderItemRepository;
import com.pizzafusion.pizzatienda.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderEntity> getAll(){
        List<OrderEntity> orders = this.orderRepository.findAll();
        orders.forEach(o -> System.out.println(o.getCustomer().getName()));
        return orders;
    }

    public List<OrderEntity> getTodayOrders(){
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.orderRepository.findAllByDateAfter(today);
    }

    public List<OrderEntity> getOutsideOrders(){
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }

    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return this.orderRepository.findCustomerOrders(idCustomer);
    }

    public void saveOrder(OrderEntity orderEntity){
        orderRepository.save(orderEntity);
    }
    @Transactional
    public void saveOrderWithItems(OrderEntity orderEntity, OrderItemEntity orderItemEntity){
        orderRepository.save(orderEntity);
        orderItemRepository.save(orderItemEntity);
    }

    public OrderSummary getSummary(int orderId) {
        return this.orderRepository.findSummary(orderId);
    }
}
