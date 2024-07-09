package com.example.secondproject.controller;

import com.example.secondproject.dto.CustomerDTO;
import com.example.secondproject.model.Customer;
import com.example.secondproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/create-customer")
     public String createCustomer(@RequestBody Customer customer) {
         customerService.saveCustomer(customer);
         return "customer created" ;
     }

     @RequestMapping("/{id}")
     public CustomerDTO getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
     }

     @PutMapping("/admin/update-customer/{id}")
    public CustomerDTO updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomerById(id, customer);
     }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

     @DeleteMapping("/delete-user/{id}")
    public String deleteUserById(@PathVariable Integer id) {
       if (customerService.deleteCustomerById(id)) {
           return "customer deleted";
     } else {
           return "customer not deleted";
       }
     }
}
