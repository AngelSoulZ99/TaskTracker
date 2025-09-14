# 👨‍🎓 Rastreador de Tareas en Java - 🟪.

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=java&logoColor=white)
![POO](https://img.shields.io/badge/OOP-Enabled-blue?style=flat-square)
![Estado](https://img.shields.io/badge/Estado-Completado-brightgreen?style=flat-square)

## 📑 Descripción.

Este es un proyecto de consola desarrollado en *Java* que permite registrar, rastrear y administrar las tareas de los usuarios. Fue realizado como parte de mi plan de formación intensivo.

El programa:
 - Permite registrar tareas deseadas por el usuario 🎒.
 - Actualizar las tareas 📔.
 - Eliminar las tareas deseadas por el usuario ❌.
 - Marca las tareas en el status deseado 💱.
 - Muestra la lista completa de tareas 🔢.
 - Muestra la lista de tareas filtrada por status 📓.

---

## 🧠 Funcionalidades del programa.

- Registro dinámico de tareas por consola ✅.
- Uso de archivos con BD en MySQL 🗑.

---

## ⚙ Tecnologías usadas.

- 💻 Java 8+.
- 🧰 POO (Clases, objetos y encapsulamiento).
- 🔄 Ciclos y condicionales.
- 📄 Conexión con JDBC.
  
---

## 📁 Estructura del código.

```bash
├── src/
├──svr.rastreadorTareas/
│   ├── conexion
│   ├──│Conexion.java                # Clase con contenido de Connection.
│   ├── datos
│   ├──│ITareaDAO.java               # Interface con comportamientos de la clase DAO.
│   ├──│TareaDAO.java                # Clase que realiza los método de la interface y conecta con la BD.
│   ├── dominio
│   ├──│Tarea.java                   # Clase que contiene el modelo de Tarea.
│   ├── presentacion
│   ├──│rastreadorTareas.java        # Clase que contiene el método main.
└── README.md
```

--- 

## 📌 Como ejecutar.

1. Asegurate de tener instalado Java (NetBeans o IntelliJ IDEA).
2. Abrimos el proyecto en donde lo hayamos descargado.
3. Descargamos la base de datos.
4. Exportamos la base de datos en nuestra BD de preferencia.
5. Editamos o actualizamos la clase conexión.
6. Editamos las dependencias en el archivo pom.xml.
7. Presionamos el botón RUN ✅.
8. Ingresas los datos solicitados.

---

## 🧑💻Autor.

*Stiven Velasquez*
® Colombia.
🕶 Proyecto realizado el 14 de Septiembre de 2025.
https://github.com/AngelSoulZ99/TaskTracker.git
