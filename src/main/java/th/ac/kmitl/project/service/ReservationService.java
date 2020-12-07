package th.ac.kmitl.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.kmitl.project.model.Reservation;
import th.ac.kmitl.project.repositories.ReservationRepo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ThaiBuddhistDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;

    public String createReservation(Reservation reservation){
        LocalDate localdate = LocalDate.from(ThaiBuddhistDate.now());
        if(reservation.getReservationDate().compareTo(localdate.toString()) <= 0){
            return "You can only reserve on the future!";
        }else if(reservation.getSeat() > 42 || reservation.getSeat() <= 0){
            return "Please enter positive integer and not more than 42!";
        }else if(!checkTableAvailability(reservation)) {
            return "Not enough table for you on selected time!";
        }else {
            reservationRepo.save(reservation);
            return null;
        }
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
    public boolean checkTableAvailability(Reservation reservation){
        List<Reservation> sameDateAndTime = findReserveByDateAndTime(reservation.getReservationDate(),
                                                                        reservation.getReservationTime());
        final int maxTable = 7;
        int totalTable = 0;
        int NumOfTable = (int)Math.ceil(reservation.getSeat()/6.0);

        for (Reservation reserve : sameDateAndTime) {
            totalTable += (int)Math.ceil(reserve.getSeat()/6.0);
        }

        if (totalTable + NumOfTable > 7){
            return false;
        }else{
            return true;
        }
    }

    public List<Reservation> findReserveByDateAndTime(String date, String time) {
        List<Reservation> sameDate = new ArrayList<Reservation>();
        List<Reservation> sameDateAndTime = new ArrayList<Reservation>();
        List<Reservation> allReserve = getReservations();
        for (Reservation reservation : allReserve) {
            if (reservation.getReservationDate().equals(date)) {
                sameDate.add(reservation);
            }
        }
        for (Reservation reservation : sameDate) {
            if (reservation.getReservationTime().equals(time)) {
                sameDateAndTime.add(reservation);
            }
        }
        return sameDateAndTime;
    }


}
