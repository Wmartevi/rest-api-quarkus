package org.rest.api.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.rest.api.entity.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
