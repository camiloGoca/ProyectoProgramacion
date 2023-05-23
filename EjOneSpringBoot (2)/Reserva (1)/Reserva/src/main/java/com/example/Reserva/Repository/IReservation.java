package com.example.Reserva.Repository;

import com.example.Reserva.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservation extends CrudRepository<Reservation, Integer> {
}