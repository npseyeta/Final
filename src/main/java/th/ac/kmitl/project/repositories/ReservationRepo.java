package th.ac.kmitl.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.ac.kmitl.project.model.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
