package com.example.javafxcrud2022sqlite;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RepositorioAlumnos {
    Connection conexion;
    public RepositorioAlumnos(){
        setConexion();
    }
    public void setConexion(){
        try {
            // db parameters
            String url = "jdbc:sqlite:sqlite/alumnos.db";            // create a connection to the database
            conexion = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            createTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createTable(){
        Statement stmt=null;
        try {
            stmt = conexion.createStatement();
            String CREATE_TABLE_SQL="CREATE TABLE IF NOT EXISTS alumnos (" +
                    "    id               INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    nombre           VARCHAR (50), apellidos VARCHAR(50), dni varchar(15), " +
                    "    fecha_nacimiento DATE" +
                    ");";
            stmt.executeUpdate(CREATE_TABLE_SQL);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    public void inserta(Alumno a){
        PreparedStatement sentencia = null;
        String sentenciaSql = "INSERT INTO alumnos (nombre, apellidos, dni, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setString(1, a.getNombre());
            sentencia.setString(2, a.getApellidos());
            sentencia.setString(3, a.getDni());
            //sentencia.setString(4, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDate.now()));
            sentencia.setString(4, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(a.getFechaNacimiento()));
            sentencia.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
