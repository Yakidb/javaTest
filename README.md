# Addresses

Este proyecto es un ejemplo práctico de un microservicio para el desarrollo de un sistema de gestion de direcciones una Arquitectura Hexagonal.

## Tecnologías necesarias

**Java** 
**SpringBoot** 
**MySQL**

## ⚙️ Instalación del proyecto

Clonar el repositorio en tu equipo:
> cd <folder path>
> git clone https://github.com/DomingoAlvarez99/videoclub-hexagonal-sync
Importar el proyecto mediante IntelliJ IDEA

## 🗄️ Script base de datos
USE test;
CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT
);

🚀 Ejecución
Desplegar el proyecto localmente: > mmvnw.cmd clean install
Arrancar el proyecto: > mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=AddressesApplication -DskipTests
✔️ Testing
Ejecutar tests unitarios: > mvnw.cmd test
