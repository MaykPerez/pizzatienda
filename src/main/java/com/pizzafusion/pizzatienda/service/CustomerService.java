package com.pizzafusion.pizzatienda.service;

import com.pizzafusion.pizzatienda.persistence.model.CustomerEntity;
import com.pizzafusion.pizzatienda.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAll(){
        return customerRepository.findAll();
    }

    @Transactional
    public void updateCustomer(String email, String id){
        customerRepository.updateEmailCustomer(email, id);
    }
}
