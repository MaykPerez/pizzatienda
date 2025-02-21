package com.pizzafusion.pizzatienda.service;

import com.pizzafusion.pizzatienda.persistence.model.PizzaEntity;
import com.pizzafusion.pizzatienda.persistence.repository.PizzaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return pizzaRepository.findAll();
    }

    public void savePizza(PizzaEntity pizzaEntity){
        pizzaRepository.save(pizzaEntity);
    }

    @Transactional
    public void deletePizza(Integer idPizza ){
        pizzaRepository.deletePizza(idPizza);
    }
}
