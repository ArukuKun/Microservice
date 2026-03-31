# ⚙️ RotomPedia Backend Microservice

Este repositorio contiene el **microservicio backend de RotomPedia**, desarrollado originalmente como parte del proyecto movil **RotomPedia**.

El objetivo de este repositorio es **centralizar el microservicio en un proyecto independiente**, el cual sera utilizado como base para implementar practicas de **DevOps, control de versiones y automatizacion CI/CD** durante el desarrollo del curso.

Este servicio expone una **API REST desarrollada con Spring Boot**, que permite consultar informacion sobre **lideres de gimnasio Pokemon por region**, datos que son consumidos por la aplicacion movil.

---

# 📌 Descripcion del Microservicio

El microservicio proporciona un endpoint REST que entrega informacion sobre **Gym Leaders** de distintas regiones del universo Pokemon.

Cada lider contiene informacion como:

- Nombre
- Region
- Tipo de especialidad
- Nombre de la medalla
- Imagen del lider

Los datos se almacenan en una **base de datos en memoria H2** y se cargan automaticamente al iniciar la aplicacion.

Este servicio fue disenado para ser consumido por la aplicacion movil **RotomPedia**, permitiendo separar la logica de backend del cliente Android.

---