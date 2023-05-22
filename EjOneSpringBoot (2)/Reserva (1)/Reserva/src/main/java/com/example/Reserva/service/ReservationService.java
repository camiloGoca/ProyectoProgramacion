package com.example.Reserva.service;

import com.example.Reserva.modelo.Reservation;
import com.example.Reserva.interfaces.IReservation;
import com.example.Reserva.interfaceService.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    private IReservation data;

    @Override
    public List<Reservation> listar() {
        return (List<Reservation>) data.findAll();
    }

    @Override
    public Optional<Reservation> listarId(int id) {
        return data.findById( id);
    }

    @Override
    public int save(Reservation p) {
        int res = 0;
        Reservation reservation = data.save(p);
        if(!reservation.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById( id);
    }
}
