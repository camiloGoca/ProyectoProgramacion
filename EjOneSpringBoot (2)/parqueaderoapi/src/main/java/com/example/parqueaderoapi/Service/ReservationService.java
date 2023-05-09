package com.example.parqueaderoapi.Service;

import com.example.parqueaderoapi.DTO.ReservationDTO;
import com.example.parqueaderoapi.Model.ParkingLot;
import com.example.parqueaderoapi.Model.Reservation;
import com.example.parqueaderoapi.Repository.ParkingLotRepository;
import com.example.parqueaderoapi.Repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ParkingLotRepository parkingLotRepository;

    public ReservationDTO makeReservation(ReservationDTO reservationDTO) {
        ParkingLot parkingLot = parkingLotRepository.findById(reservationDTO.getParkingLotId())
                .orElseThrow(() -> new ResourceNotFoundException("ParkingLot", "id", reservationDTO.getParkingLotId()));

        LocalDateTime startTime = reservationDTO.getStartTime();
        LocalDateTime endTime = reservationDTO.getEndTime();

        List<Reservation> overlappingReservations = reservationRepository.findByParkingLotId(parkingLot.getId())
                .stream()
                .filter(r -> (r.getStartTime().isBefore(endTime) && r.getEndTime().isAfter(startTime)))
                .collect(Collectors.toList());

        if (!overlappingReservations.isEmpty()) {
            throw new ReservationConflictException("The reservation conflicts with another existing reservation");
        }

        Reservation reservation = new Reservation();
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setLicensePlate(reservationDTO.getLicensePlate());
        reservation.setParkingLot(parkingLot);

        BigDecimal totalPrice = calculateTotalPrice(startTime, endTime, parkingLot.getPricePerHour());
        reservation.setTotalPrice(totalPrice);

        reservationRepository.save(reservation);

        reservationDTO.setId(reservation.getId());
        reservationDTO.setTotalPrice(totalPrice);
        return reservationDTO;
    }

    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));
        reservationRepository.delete(reservation);
    }

    private BigDecimal calculateTotalPrice(LocalDateTime startTime, LocalDateTime endTime, BigDecimal pricePerHour) {
        long durationMinutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long durationHours = durationMinutes / 60;
        BigDecimal totalPrice = pricePerHour.multiply(BigDecimal.valueOf(durationHours));
        return totalPrice;
    }
}


