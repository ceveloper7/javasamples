package org.ceva.ch02.tag;

import java.util.ArrayList;
import java.util.List;

public class CustomersRepository {
    private List<Customer> customers = new ArrayList<Customer>();

    public boolean contains(String name){
        return customers.stream()
                .anyMatch((customer -> customer.getName().equals(name)));
    }

    public void persist(Customer customer){
        customers.add(customer);
    }
}
