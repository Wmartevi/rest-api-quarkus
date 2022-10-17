package org.rest.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rest.api.entity.Customer;
import org.rest.api.repository.CustomerRepository;
import org.rest.api.util.DateUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService {

    private final DateUtil dateUtil;

    @Inject
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        log.info("list Customers " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return customerRepository.findAll().list();
    }
    public Customer findCustomerById(long id){
        log.info("Get Customer");
        return customerRepository.findById(id);
    }
    public void addCustomer(Customer customer){
        log.info("Add Customer");
        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        log.info("Delete Customer");
        Customer savedCustomer = customerRepository.findById(id);

        if (savedCustomer == null){
            log.error("Id not found " + id);
            throw new WebApplicationException("Not Found " + id + " does not exists", Response.Status.NOT_FOUND);
        }

        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer customer){
        Customer savedCustomer = customerRepository.findById(id);
        log.info("Update Customer");
        if (savedCustomer == null){
            log.error("Id not found " + id);
            throw new WebApplicationException("Not Found " + id + " does not exists", Response.Status.NOT_FOUND);
        }

        savedCustomer.setName(customer.getName());
        savedCustomer.setLastName(customer.getLastName());
        savedCustomer.setAge(customer.getAge());
        savedCustomer.setEmail(customer.getEmail());

        return savedCustomer;

    }
}
