package th.ac.kmitl.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.kmitl.project.model.Customer;
import th.ac.kmitl.project.model.Reservation;
import th.ac.kmitl.project.repositories.ReservationRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    public void createReservation(Reservation reservation){
        reservationRepo.save(reservation);
    }

    public List<Reservation> getReservations() {
        return reservationRepo.findAll();
    }

    public Reservation findReservation(int id) {
        try {
            return reservationRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
