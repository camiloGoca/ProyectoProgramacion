package com.example.parqueaderoapi.Controller;

import com.example.parqueaderoapi.DTO.ReservationDTO;
import com.example.parqueaderoapi.Service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> makeReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO result = reservationService.makeReservation(reservationDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.noContent().build();
    }
}