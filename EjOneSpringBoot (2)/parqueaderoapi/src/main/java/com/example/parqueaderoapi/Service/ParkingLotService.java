package com.example.parqueaderoapi.Service;

import com.example.parqueaderoapi.DTO.ParkingLotDTO;
import com.example.parqueaderoapi.Model.ParkingLot;
import com.example.parqueaderoapi.Repository.ParkingLotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<ParkingLotDTO> getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        return parkingLots.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ParkingLotDTO getParkingLotById(Long id) {
        ParkingLot parkingLot = parkingLotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ParkingLot", "id", id));
        return mapToDTO(parkingLot);
    }

    private ParkingLotDTO mapToDTO(ParkingLot parkingLot) {
        ParkingLotDTO dto = new ParkingLotDTO();
        dto.setId(parkingLot.getId());
        dto.setName(parkingLot.getName());
        dto.setAddress(parkingLot.getAddress());
        dto.setCapacity(parkingLot.getCapacity());
        dto.setPricePerHour(parkingLot.getPricePerHour());
        return dto;
    }
}
