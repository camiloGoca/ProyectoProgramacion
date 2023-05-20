package com.example.Reserva.interfaceService;

import com.example.Reserva.modelo.Reservation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.Reserva"})
public interface IReservationService {
    public List<Reservation> listar();
    public Optional<Reservation> listarId(int id);
    public int save(Reservation p);
    public void delete(int id);
}
