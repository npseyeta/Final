package th.ac.kmitl.project.service;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.kmitl.project.model.Customer;
import th.ac.kmitl.project.repositories.CustomerRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void createCustomer(Customer customer) {
        String hashPassword = hash(customer.getPassword());
        customer.setPassword(hashPassword);
        customerRepo.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public Customer findCustomer(int id) {
        try {
            return customerRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Customer checkPassword(Customer customer) {
        Customer storesCustomer = findCustomer(customer.getId());

        if (storesCustomer != null) {
            String hashPassword = storesCustomer.getPassword();

            if (BCrypt.checkpw(customer.getPassword(), hashPassword))
                return storesCustomer;
        }
        return null;
    }

    private String hash(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }
}