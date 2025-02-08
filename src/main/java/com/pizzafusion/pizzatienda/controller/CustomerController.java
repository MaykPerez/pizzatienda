package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.service.CustomerService;
import com.pizzafusion.pizzatienda.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String customerList(Model model){

        model.addAttribute("customers", customerService.getAll());
        return "customer";
    }
}
