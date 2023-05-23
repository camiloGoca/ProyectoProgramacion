package com.example.Reserva.interfaces;

import com.example.Reserva.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;
public interface IReservation extends CrudRepository<Reservation, Integer> {
}