package com.crm.rest.restservices;

import com.crm.rest.entity.Customer;
import com.crm.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


    @Autowired
    CustomerService customerService;


    @GetMapping("/customers")
   public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer==null){
            throw  new CustomerNotFoundException("Customer id not found " + customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        customer.setId(0);
        customerService.saveCustomer(customer);

        return customer;

    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);

        return customer;

    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer (@PathVariable int customerId){

        customerService.deleteCustomer(customerId);

        return "Deleted customer id " + customerId;
    }
}
