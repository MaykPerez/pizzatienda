package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import com.pizzafusion.pizzatienda.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("nombre", "Usuario");
        return "pizza";
    }

    @GetMapping("/pizza")
    public String listPizza(Model model){

        List<PizzaEntity> pizzasList= new ArrayList<>();
        pizzasList = pizzaService.getAll();

        model.addAttribute("pizzas", pizzasList);
        return "pizza";
    }
}
