package th.ac.kmitl.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Time;

@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int ReservationID;
    private final int Seat;
    private final int CustomerID;
    private final Time ReservationTime;
    private final Date ReservationDate;

    public Reservation(int ReservationID, int Seat, int CustomerID, Date ReservationDate, Time ReservationTime) {
        this.ReservationID = ReservationID;
        this.Seat = Seat;
        this.CustomerID = CustomerID;
        this.ReservationDate = ReservationDate;
        this.ReservationTime = ReservationTime;
    }

    public int getReservationID() {
        return ReservationID;
    }

    public int getSeat() {
        return Seat;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public Time getReservationTime() {
        return ReservationTime;
    }

    public Date getReservationDate() {
        return ReservationDate;
    }
}
