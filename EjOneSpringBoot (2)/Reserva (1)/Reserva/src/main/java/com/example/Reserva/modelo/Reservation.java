package com.example.Reserva.modelo;


import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;
    private String nombre;
    private String Matrícula;
    private long telefono ;
    private String hora_fecha;
    private String tipo;
    private String parqueadero;

    public Reservation() {

    }

    public Reservation(int id, String nombre, String matrícula, long telefono, String hora_fecha,String tipo,String parqueadero) {
        this.id=id;
        this.nombre = nombre;
        this.Matrícula = matrícula;
        this.telefono = telefono;
        this.hora_fecha = hora_fecha;
        this.tipo=tipo;
        this.parqueadero=parqueadero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatrícula() {
        return Matrícula;
    }

    public void setMatrícula(String matrícula) {
        Matrícula = matrícula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getHora_fecha() {
        return hora_fecha;
    }

    public void setHora_fecha(String hora_fecha) {
        this.hora_fecha = hora_fecha;
    }

}
