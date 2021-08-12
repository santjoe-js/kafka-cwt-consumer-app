/**
 * 
 */
package com.cwt.kafka.consumer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cwt.kafka.consumer.entity.Customer;

@Repository
public interface CustomerRepository1 extends CrudRepository<Customer, String> {

  public Customer findByFirstName(String firstName);
  public List<Customer> findByLastName(String lastName);

}
