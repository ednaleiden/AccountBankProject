package com.banca.digital.banca_digital.DTO;

public class ClienteDTO {

    //DTO NO SE MAPEA A NINGUNA BASE DE DATOS

    private  Long id;

    private  String nombre;

    //private  String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*

    public void setEmail(String email) {
        this.email = email;
    }*/

    //se va a crear una clase que puede pasar una entidad a DTO y viseversa eso se hace en los mappers
}
