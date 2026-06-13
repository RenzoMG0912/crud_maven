<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.universidad.modelo.Alumno" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Universidad | Gestión de Alumnos</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Gestión de Alumnos</h1>
            <p>Administra el registro de estudiantes</p>
        </div>
        
        <div class="card">
            <div class="card-header">
                <div></div>
                <a href="crear.jsp" class="btn btn-primary">
                    Nuevo Alumno
                </a>
            </div>
            <div class="card-body">
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Edad</th>
                                <th>Curso</th>
                                <th>Fecha Registro</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");
                                if (alumnos == null || alumnos.isEmpty()) {
                            %>
                                <tr>
                                    <td colspan="7" style="text-align: center; color: #64748b;">
                                        No hay alumnos registrados
                                    </td>
                                </tr>
                            <%
                                } else {
                                    for (Alumno a : alumnos) {
                            %>
                                <tr>
                                    <td><span class="badge"><%= a.getId() %></span></td>
                                    <td><%= a.getNombre() %></td>
                                    <td><%= a.getEmail() %></td>
                                    <td><%= a.getEdad() %></td>
                                    <td><%= a.getCurso() %></td>
                                    <td><%= a.getFechaRegistro() %></td>
                                    <td>
                                        <a href="alumno?accion=editar&id=<%= a.getId() %>" class="btn btn-edit" style="padding: 0.25rem 0.75rem; font-size: 0.75rem; margin-right: 0.5rem;">Editar</a>
                                        <a href="alumno?accion=eliminar&id=<%= a.getId() %>" class="btn btn-delete" style="padding: 0.25rem 0.75rem; font-size: 0.75rem;" onclick="return confirm('¿Estás seguro de eliminar este alumno?')">Eliminar</a>
                                    </td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>