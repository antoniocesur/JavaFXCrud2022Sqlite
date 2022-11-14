package com.example.javafxcrud2022sqlite;

import java.time.LocalDate;
import java.sql.Date;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fechaNacimiento;

    public Alumno(){
        nombre="Pepito";
        apellidos="de los Palotes";
        dni="123456J";
        fechaNacimiento= java.sql.Date.valueOf(LocalDate.now());
    }
}
