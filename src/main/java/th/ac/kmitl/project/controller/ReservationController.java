package th.ac.kmitl.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.kmitl.project.model.Reservation;
import th.ac.kmitl.project.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservationPage() {
        return "reservation";
    }

    @PostMapping
    public String reservation(@RequestBody @ModelAttribute Reservation reservation) {
        reservationService.createReservation(reservation);
        return "home";
    }
}

