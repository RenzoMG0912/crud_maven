<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Universidad | Nuevo Alumno</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Nuevo Alumno</h1>
            <p>Completa el formulario para registrar un estudiante</p>
        </div>
        
        <div class="card">
            <div class="card-body">
                <div class="form-container">
                    <form action="alumno" method="post">
                        <input type="hidden" name="accion" value="insertar">
                        
                        <div class="form-group">
                            <label for="nombre">Nombre completo</label>
                            <input type="text" id="nombre" name="nombre" required placeholder="Ej: Juan Pérez">
                        </div>
                        
                        <div class="form-group">
                            <label for="email">Correo electrónico</label>
                            <input type="email" id="email" name="email" required placeholder="juan@ejemplo.com">
                        </div>
                        
                        <div class="form-group">
                            <label for="edad">Edad</label>
                            <input type="number" id="edad" name="edad" required min="1" max="120">
                        </div>
                        
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <input type="text" id="curso" name="curso" required placeholder="Ej: Matemáticas, Programación, etc.">
                        </div>
                        
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">Guardar Alumno</button>
                            <a href="alumno?accion=listar" class="btn btn-outline">Cancelar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>