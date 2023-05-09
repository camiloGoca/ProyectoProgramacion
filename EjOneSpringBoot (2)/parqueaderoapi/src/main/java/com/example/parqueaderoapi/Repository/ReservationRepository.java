package com.example.parqueaderoapi.Repository;

import com.example.parqueaderoapi.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByParkingLotId(Long parkingLotId);
}