package th.ac.kmitl.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.kmitl.project.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
