package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.service.CustomerService;
import com.pizzafusion.pizzatienda.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String customerList(Model model){

        model.addAttribute("customers", customerService.getAll());
        return "customer";
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestParam String customerId, @RequestParam String email){
        customerService.updateCustomer(email, customerId);
        return "redirect:/customer";
    }
}
