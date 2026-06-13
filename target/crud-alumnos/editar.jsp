<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.universidad.modelo.Alumno" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Universidad | Editar Alumno</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Editar Alumno</h1>
            <p>Modifica los datos del estudiante</p>
        </div>
        
        <div class="card">
            <div class="card-body">
                <div class="form-container">
                    <%
                        Alumno alumno = (Alumno) request.getAttribute("alumno");
                        if (alumno == null) {
                            response.sendRedirect("alumno?accion=listar");
                            return;
                        }
                    %>
                    
                    <form action="alumno" method="post">
                        <input type="hidden" name="accion" value="actualizar">
                        <input type="hidden" name="id" value="<%= alumno.getId() %>">
                        
                        <div class="form-group">
                            <label for="nombre">Nombre completo</label>
                            <input type="text" id="nombre" name="nombre" value="<%= alumno.getNombre() %>" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="email">Correo electrónico</label>
                            <input type="email" id="email" name="email" value="<%= alumno.getEmail() %>" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="edad">Edad</label>
                            <input type="number" id="edad" name="edad" value="<%= alumno.getEdad() %>" required min="1" max="120">
                        </div>
                        
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <input type="text" id="curso" name="curso" value="<%= alumno.getCurso() %>" required>
                        </div>
                        
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">Actualizar Alumno</button>
                            <a href="alumno?accion=listar" class="btn btn-outline">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>