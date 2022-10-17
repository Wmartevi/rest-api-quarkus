package org.rest.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
}
