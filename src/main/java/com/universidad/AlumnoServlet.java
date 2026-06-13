package com.universidad;

import com.universidad.dao.AlumnoDAO;
import com.universidad.modelo.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/alumno")
public class AlumnoServlet extends HttpServlet {
    
    private AlumnoDAO alumnoDAO;
    
    @Override
    public void init() {
        alumnoDAO = new AlumnoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        try {
            if (accion == null || accion.equals("listar")) {
                listarAlumnos(request, response);
            } else if (accion.equals("editar")) {
                mostrarFormularioEditar(request, response);
            } else if (accion.equals("eliminar")) {
                eliminarAlumno(request, response);
            } else {
                listarAlumnos(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        
        try {
            if (accion.equals("insertar")) {
                insertarAlumno(request, response);
            } else if (accion.equals("actualizar")) {
                actualizarAlumno(request, response);
            } else {
                listarAlumnos(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    private void listarAlumnos(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        List<Alumno> alumnos = alumnoDAO.listarTodos();
        request.setAttribute("alumnos", alumnos);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String curso = request.getParameter("curso");
        
        Alumno alumno = new Alumno(nombre, email, edad, curso);
        alumnoDAO.insertar(alumno);
        response.sendRedirect("alumno?accion=listar");
    }
    
    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = alumnoDAO.obtenerPorId(id);
        request.setAttribute("alumno", alumno);
        request.getRequestDispatcher("/editar.jsp").forward(request, response);
    }
    
    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String curso = request.getParameter("curso");
        
        Alumno alumno = new Alumno(id, nombre, email, edad, curso, null);
        alumnoDAO.actualizar(alumno);
        response.sendRedirect("alumno?accion=listar");
    }
    
    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));
        alumnoDAO.eliminar(id);
        response.sendRedirect("alumno?accion=listar");
    }
}