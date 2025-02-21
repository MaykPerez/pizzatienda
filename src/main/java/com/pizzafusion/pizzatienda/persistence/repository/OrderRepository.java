package com.pizzafusion.pizzatienda.persistence.repository;

import com.pizzafusion.pizzatienda.persistence.model.OrderEntity;
import com.pizzafusion.pizzatienda.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository  extends ListCrudRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByDateAfter(LocalDateTime date);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
    @Query(value= "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param("id") String id);

    @Query(value= "SELECT  po.id_order AS idOrder, cu.name AS customerName, po.date AS orderDate, " +
            "po.total AS orderGlobal, GROUP_CONCAT(pi.name) AS pizzaName \n" +
            "FROM pizza_order po \n" +
            "   INNER JOIN customer cu ON po.id_customer = cu.id_customer \n" +
            "   INNER JOIN order_item oi ON po.id_order = oi.id_order \n" +
            "   INNER JOIN pizza pi ON oi.id_pizza = pi.id_pizza \n" +
            "WHERE po.id_order = :orderId \n" +
            "GROUP BY po.id_order, cu.name, po.date, po.total;", nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") int orderId);

    @Procedure(value="take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);

}
