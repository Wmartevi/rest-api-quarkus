package org.rest.api.controller;

import org.rest.api.entity.Customer;
import org.rest.api.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/api/customer")
public class CustomerController {
    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> retrieveCustomers(){
        return customerService.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    public Customer findById(long id){
        return customerService.findCustomerById(id);
    }

    @POST
    @Transactional
    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Customer updateCustomer(long id, Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteCustomer(long id){
        customerService.deleteCustomer(id);
    }
}
