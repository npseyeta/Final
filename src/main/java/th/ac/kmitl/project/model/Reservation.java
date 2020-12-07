package th.ac.kmitl.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ReservationID;

    private int Seat;
    private String ReservationTime = new SimpleDateFormat("HHmmss").format(new Date());
    private String ReservationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private String CustomerEmail;
    private String CustomerName;
    private String CustomerTel;


    public  Reservation(){

    }

    public Reservation(int ReservationID,
                       int Seat,
                       String ReservationDate,
                       String ReservationTime,
                       String CustomerName,
                       String CustomerEmail,
                       String CustomerTel) {
        this.ReservationID = ReservationID;
        this.Seat = Seat;
        this.ReservationDate = ReservationDate;
        this.ReservationTime = ReservationTime;
        this.CustomerName = CustomerName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerTel = CustomerTel;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setCustomerTel(String customerTel) {
        CustomerTel = customerTel;
    }

    public void setReservationID(int reservationID) {
        this.ReservationID = reservationID;
    }

    public void setSeat(int seat) {
        this.Seat = seat;
    }

    public void setCustomerEmail(String customerEmail) {
        this.CustomerEmail = customerEmail;
    }

    public void setReservationTime(String reservationTime) {
        this.ReservationTime = reservationTime;
    }

    public void setReservationDate(String reservationDate) {
        this.ReservationDate = reservationDate;
    }

    public int getReservationID() {
        return ReservationID;
    }

    public int getSeat() {
        return Seat;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public String getReservationTime() {
        return ReservationTime;
    }

    public String getReservationDate() {
        return ReservationDate;
    }

    public String getCustomerTel() {
        return CustomerTel;
    }

    public String getCustomerName() {
        return CustomerName;
    }
}
