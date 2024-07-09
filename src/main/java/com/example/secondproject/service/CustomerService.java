package com.example.secondproject.service;

import com.example.secondproject.dto.CustomerDTO;
import com.example.secondproject.model.Customer;
import com.example.secondproject.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;
 /*
  * save the Cutomer data in customer table
  */
    public Customer saveCustomer(Customer customer) {
        // modelMapper.map(customer,CustomerDTO.class);
         return customerRepository.save(customer);
    }

  /*
   * fetch the customer data based on customer id
   */
    public CustomerDTO getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomerById(Integer id, Customer customer) {
        if((customerRepository.findById(id).equals(customer.getId()))) {
          customerRepository.save(customer);
        } else {
            return modelMapper.map(customer, CustomerDTO.class);
        }
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepository.findAll();
        List<CustomerDTO> getAllCustomerDTOS = new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            getAllCustomerDTOS.add(modelMapper.map(customer, CustomerDTO.class));
        }
        return  getAllCustomerDTOS;
    }

    public boolean deleteCustomerById(Integer id) {
        Optional<Customer> customer;
        boolean isDeleted;
        customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        }
        customer = customerRepository.findById(id);
        if (customer.isPresent()) {
          return isDeleted = false;
        } else {
          return isDeleted = true;
        }
    }
}
