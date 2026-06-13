package com.universidad.dao;

import com.universidad.modelo.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    
    public void insertar(Alumno alumno) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO alumnos (nombre, email, edad, curso) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getEmail());
            pstmt.setInt(3, alumno.getEdad());
            pstmt.setString(4, alumno.getCurso());
            pstmt.executeUpdate();
        }
    }
    
    public List<Alumno> listarTodos() throws SQLException, ClassNotFoundException {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos ORDER BY id DESC";
        
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setEmail(rs.getString("email"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCurso(rs.getString("curso"));
                alumno.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }
    
    public Alumno obtenerPorId(int id) throws SQLException, ClassNotFoundException {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setId(rs.getInt("id"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setEmail(rs.getString("email"));
                    alumno.setEdad(rs.getInt("edad"));
                    alumno.setCurso(rs.getString("curso"));
                    alumno.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                }
            }
        }
        return alumno;
    }
    
    public void actualizar(Alumno alumno) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE alumnos SET nombre = ?, email = ?, edad = ?, curso = ? WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getEmail());
            pstmt.setInt(3, alumno.getEdad());
            pstmt.setString(4, alumno.getCurso());
            pstmt.setInt(5, alumno.getId());
            pstmt.executeUpdate();
        }
    }
    
    public void eliminar(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}