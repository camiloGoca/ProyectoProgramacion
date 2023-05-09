package com.example.parqueaderoapi.Controller;

import com.example.parqueaderoapi.DTO.ParkingLotDTO;
import com.example.parqueaderoapi.Service.ParkingLotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLots() {
        List<ParkingLotDTO> parkingLots = parkingLotService.getAllParkingLots();
        return ResponseEntity.ok(parkingLots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotById(@PathVariable Long id) {
        ParkingLotDTO parkingLot = parkingLotService.getParkingLotById(id);
        return ResponseEntity.ok(parkingLot);
    }
}