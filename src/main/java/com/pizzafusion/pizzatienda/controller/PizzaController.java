package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import com.pizzafusion.pizzatienda.service.PizzaService;
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
    public String home(Model model) {
        model.addAttribute("nombre", "Usuario");
        return "pizza";
    }

    @GetMapping("/pizza")
    public String listPizza(Model model) {
        List<PizzaEntity> pizzasList = pizzaService.getAll();
        model.addAttribute("pizzas", pizzasList);
        return "pizza";
    }

    @GetMapping("/principal")
    public String showPrincipal(Model model) {
        List<PizzaEntity> pizzasList = pizzaService.getAll();
        List<List<PizzaEntity>> paginatedPizzas = paginateList(pizzasList, 5);
        model.addAttribute("paginatedPizzas", paginatedPizzas);  // Cambio aquí
        return "principal";
    }

    private List<List<PizzaEntity>> paginateList(List<PizzaEntity> list, int pageSize) {
        List<List<PizzaEntity>> pages = new ArrayList<>();
        for (int i = 0; i < list.size(); i += pageSize) {
            pages.add(list.subList(i, Math.min(i + pageSize, list.size())));
        }
        return pages;
    }
}
