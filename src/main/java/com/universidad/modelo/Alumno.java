package com.universidad.modelo;

import java.sql.Timestamp;

public class Alumno {
    
    private int id;
    private String nombre;
    private String email;
    private int edad;
    private String curso;
    private Timestamp fechaRegistro;
    
    public Alumno() {}
    
    public Alumno(int id, String nombre, String email, int edad, String curso, Timestamp fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.curso = curso;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Alumno(String nombre, String email, int edad, String curso) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.curso = curso;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "', email='" + email + "', edad=" + edad + ", curso='" + curso + "'}";
    }
}