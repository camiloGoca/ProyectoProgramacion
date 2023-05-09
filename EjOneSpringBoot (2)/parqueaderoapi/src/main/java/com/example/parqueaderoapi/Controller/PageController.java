package com.example.parqueaderoapi.Controller;

import com.example.parqueaderoapi.DTO.ParkingLotDTO;
import com.example.parqueaderoapi.DTO.ReservationDTO;
import com.example.parqueaderoapi.Service.ParkingLotService;
import com.example.parqueaderoapi.Service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class PageController {
    private final ParkingLotService parkingLotService;
    private final ReservationService reservationService;

    public PageController(ParkingLotService parkingLotService, ReservationService reservationService) {
        this.parkingLotService = parkingLotService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index (Model model) {
        List<ParkingLotDTO> parkingLots = parkingLotService.getAllParkingLots();
        model.addAttribute("parkingLots", parkingLots);
        return "index";
    }

    @GetMapping("/parking-lot/{id}")
    public String parkingLot(@PathVariable Long id, Model model) {
        ParkingLotDTO parkingLot = parkingLotService.getParkingLotById(id);
        model.addAttribute("parkingLot", parkingLot);
        return "parkingLot";
    }

    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        List<ParkingLotDTO> parkingLots = parkingLotService.getAllParkingLots();
        model.addAttribute("parkingLots", parkingLots);
        return "reservationForm";
    }

    @PostMapping("/reservation")
    public String makeReservation(@ModelAttribute("reservationDTO") ReservationDTO reservationDTO, Model model) {
        reservationDTO = reservationService.makeReservation(reservationDTO);
        model.addAttribute("reservation", reservationDTO);
        return "reservationConfirmation";
    }
}
