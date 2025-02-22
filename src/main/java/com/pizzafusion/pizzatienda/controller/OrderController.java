package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.persistence.model.OrderEntity;
import com.pizzafusion.pizzatienda.persistence.model.OrderItemEntity;
import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import com.pizzafusion.pizzatienda.service.OrderItemService;
import com.pizzafusion.pizzatienda.service.OrderService;
import com.pizzafusion.pizzatienda.service.PizzaService;
//import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final PizzaService pizzaService;
    private final OrderItemService orderItemService;

    public OrderController(OrderService orderService, PizzaService pizzaService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public String formOrder(Model model){
         List<OrderEntity> orders = orderService.getAll();
         model.addAttribute("orders", orders);
        model.addAttribute("orderItemEntity", new OrderItemEntity());
        System.out.println("Se ejecuto el endpoint");
        return "order";
    }

    @PostMapping("/orderPizza")
    public String saveOrder(@ModelAttribute OrderItemEntity orderItemEntity){

        OrderEntity orderEntity = new OrderEntity();

        //orderEntity.setIdOrder(8);
        orderEntity.setIdCustomer("782668115");
        orderEntity.setDate(LocalDateTime.now());
        orderEntity.setTotal(orderItemEntity.getPrice());
        orderEntity.setMethod("D");

        orderService.saveOrderWithItems(orderEntity, orderItemEntity);

        return "redirect:/order";
    }

    //orderPizza

/*    @GetMapping("/all")
    public String getAll(){
        return orderService.getAll();
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders(){
        return ResponseEntity.ok(orderService.getTodayOrders());
    }
    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(orderService.getOutsideOrders());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String id){
        return ResponseEntity.ok(orderService.getCustomerOrders(id));
    }
    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable int id){
        return ResponseEntity.ok(orderService.getSummary(id));
    }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto) {
        return ResponseEntity.ok(this.orderService.saveRandomOrder(dto));
    }*/

}
