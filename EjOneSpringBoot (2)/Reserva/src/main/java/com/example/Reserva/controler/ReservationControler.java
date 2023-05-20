package com.example.Reserva.controler;

import com.example.Reserva.modelo.Reservation;
import com.example.Reserva.interfaceService.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ReservationControler {


    @Autowired
    private IReservationService service;


    @GetMapping("/listar")
    public String listar(@org.jetbrains.annotations.NotNull Model model){
        List<Reservation>reservation= service.listar();
        model.addAttribute("reservation", reservation);
        return "ConfirmacionReversa";
    }

    @GetMapping("/Reserva/parqueadero/A")
    public String agregar(Model model){
        model.addAttribute("reservation", new Reservation());
        return "FormularioDeReversaA";
    }
    @GetMapping("/inicio")
    public String agregar1(Model model){

        return "Indice";
    }
    @GetMapping("/Reserva/parqueadero/B")
    public String agregar2(Model model){
        model.addAttribute("reservation", new Reservation());
        return "FormularioDeReversaB";
    }
    @GetMapping("/Reserva/parqueadero/c")
    public String agregar3(Model model){
        model.addAttribute("reservation", new Reservation());
        return "FormularioDeReversaC";
    }
    @GetMapping("/Reserva/parqueadero/editar")
    public String agregar4(Model model){
        model.addAttribute("reservation", new Reservation());
        return "FormularioDeReversaEditar";
    }

    @PostMapping("/save")
    public String save(@Validated Reservation p){
        service.save(p);
        return "Indice";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Reservation> reservation = service.listarId(id);
        model.addAttribute("reservation", reservation);
        return "redirect:/Reserva/parqueadero/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }



}
