package com.pizzafusion.pizzatienda.controller;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import com.pizzafusion.pizzatienda.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pizza")
@Controller
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }



    @GetMapping
    public String listPizza(Model model) {
        List<PizzaEntity> pizzasList = pizzaService.getAll();
        model.addAttribute("pizzas", pizzasList);
        model.addAttribute("pizza", new PizzaEntity());
        return "pizza";
    }

    @PostMapping("/save")
    public String savePizza(@ModelAttribute PizzaEntity pizzaEntity) {
        pizzaService.savePizza(pizzaEntity);

        return "redirect:/pizza";
    }

    @PostMapping("/delete")
    public String deletePizza(@RequestParam("idPizza") Integer idPizza ){
        pizzaService.deletePizza(idPizza);
        return "redirect:/pizza";

    }

}
