package th.ac.kmitl.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.kmitl.project.model.Reservation;
import th.ac.kmitl.project.service.ReservationService;


@Controller
@RequestMapping
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    public String getReservePage(){
        return "reservation";
    }

    @PostMapping("/reservation")
    public String reservation(Reservation reservation,
                              @RequestParam String email,
                              @RequestParam String name,
                              @RequestParam String tel,
                              @RequestParam String time,
                              @RequestParam String date,
                              Model model){
        reservation.setCustomerEmail(email);
        reservation.setCustomerName(name);
        reservation.setCustomerTel(tel);
        reservation.setReservationTime(time);
        reservation.setReservationDate(date);
        String messeage = reservationService.createReservation(reservation);
        if (messeage == null){
            model.addAttribute("success", "Your Reservation was successfully place!");
        }else{
            model.addAttribute("error", messeage);
        }
        return "reservation";
    }
}

