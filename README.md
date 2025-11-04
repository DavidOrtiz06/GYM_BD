🏋️‍♂️ GYM-BD – Sistema de Recepción y Gestión de Gimnasio

Proyecto académico desarrollado como parte del curso de Bases de Datos / Ingeniería de Software, cuyo objetivo es diseñar e implementar un sistema de gestión integral para la recepción de un gimnasio, permitiendo la administración eficiente de clientes, entrenadores, fisioterapeutas, horarios, suscripciones y valoraciones.

------------------------------------------------------------
🎯 OBJETIVO GENERAL
------------------------------------------------------------
Desarrollar un sistema de escritorio que gestione el registro, control y seguimiento de los usuarios de un gimnasio, utilizando una base de datos relacional y una arquitectura por capas en Java (MVC).

------------------------------------------------------------
🧩 OBJETIVOS ESPECÍFICOS
------------------------------------------------------------
- Diseñar el modelo lógico y físico de la base de datos del gimnasio.
- Implementar el RDBMS MySQL en una máquina virtual Ubuntu 24.04 LTS.
- Desarrollar una aplicación Java conectada al servidor remoto (VM).
- Implementar operaciones CRUD para las entidades principales del sistema.
- Registrar logs de actividad y asegurar la persistencia de los datos.

------------------------------------------------------------
🏗️ ARQUITECTURA GENERAL
------------------------------------------------------------
El sistema sigue el patrón de diseño Modelo–Vista–Controlador (MVC):

Vista (UI) → Java Swing / JavaFX
Controladores → Gestionan la lógica de interacción
Servicios / DAO → Lógica de negocio y acceso a datos
Base de Datos → MySQL en VM Ubuntu 24.04

------------------------------------------------------------
⚙️ TECNOLOGÍAS UTILIZADAS
------------------------------------------------------------
Lenguaje: Java 17+
IDE: IntelliJ IDEA
Base de Datos: MySQL 8.0
Virtualización: VirtualBox
Patrón: MVC + DAO
Conexión: JDBC
Control de versiones: Git / GitHub

------------------------------------------------------------
🧱 ESTRUCTURA DEL PROYECTO
------------------------------------------------------------
GYM_BD/
├── src/
│   ├── co/edu/unbosque/controller/
│   ├── co/edu/unbosque/service/
│   ├── co/edu/unbosque/dao/
│   ├── co/edu/unbosque/model/
│   ├── co/edu/unbosque/view/
│   └── co/edu/unbosque/utils/
│
├── db/
│   ├── 01_creacion_tablas.sql
│   ├── 02_insercion_datos.sql
│   ├── 03_scripts_varios.sql
│   └── README_BD.md
│
├── docs/
│   ├── Documento_Implementacion_VM.pdf
│   ├── Documento_Implementacion_RDBMS.pdf
│   └── Documento_Analisis_Seleccion_SO_RDBMS.pdf
│
├── .gitignore
├── README.md
└── pom.xml (si se usa Maven)

------------------------------------------------------------
🧠 ENTIDADES PRINCIPALES
------------------------------------------------------------
- Cliente: Datos personales, contacto y estado de membresía.
- Entrenador: Información de turnos, formación y experiencia.
- Fisioterapeuta: Datos de atención y control de valoraciones.
- Suscripción: Tipos de membresía (1, 3, 6 meses) y estado actual.
- Valoración: Registro de revisión física o médica del cliente.
- Horario / Clase: Control de cupos y disponibilidad.

------------------------------------------------------------
🖥️ CONFIGURACIÓN DEL ENTORNO
------------------------------------------------------------
1. CONFIGURAR MÁQUINA VIRTUAL:
   - Sistema operativo: Ubuntu 24.04 LTS
   - Instalar MySQL Server:
     sudo apt update
     sudo apt install mysql-server

   - Verificar estado del servicio:
     sudo systemctl status mysql

2. CONFIGURAR RED EN VIRTUALBOX:
   Adaptador NAT con redirección de puertos:
   Host Port: 3306
   Guest Port: 3306

3. CREAR BASE DE DATOS Y USUARIO:
   CREATE DATABASE GIMNASIOLINUX;
   CREATE USER 'root'@'%' IDENTIFIED BY 'root1234';
   GRANT ALL PRIVILEGES ON gimnasioLinux.* TO 'root'@'%';
   FLUSH PRIVILEGES;

------------------------------------------------------------
💡 CONEXIÓN DESDE INTELLIJ (Windows → Ubuntu VM)
------------------------------------------------------------
Host: 127.0.0.1
Port: 3306
User: root
Password: root1234
Database: GIMNASIOLINUX

------------------------------------------------------------
🚀 EJECUCIÓN DEL PROYECTO
------------------------------------------------------------
1. Clonar el repositorio:
   git clone https://github.com/usuario/GYM_BD.git
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar el driver JDBC de MySQL.
4. Ejecutar la clase principal (Main.java).
5. Verificar la conexión con la base de datos en la consola.

------------------------------------------------------------
🧾 LOGS DEL SISTEMA
------------------------------------------------------------
El sistema mantiene un registro automático de actividades:
- login/logout de usuarios
- operaciones CRUD realizadas
- errores de conexión o consulta

Ruta de logs:
   /logs/actividad_gym.log

------------------------------------------------------------
🧰 SCRIPTS INCLUIDOS
------------------------------------------------------------
Creación: 01_creacion_tablas.sql
Inserción: 02_insercion_datos.sql
Varios: 03_scripts_varios.sql

------------------------------------------------------------
📚 DOCUMENTOS TÉCNICOS
------------------------------------------------------------
/docs:
- Documento de Implementación de la VM
- Documento de Implementación del RDBMS
- Documento de Análisis de Selección del SO y RDBMS

------------------------------------------------------------
👥 AUTORES
------------------------------------------------------------
Nombre: David Ortiz & Diego Rodriguez
Rol: Desarrollador / Analista
Contacto: dortizort@unbosque.edu.co & dcrodriguezl@unbosque.edu.co

------------------------------------------------------------
🧩 LICENCIA
------------------------------------------------------------
Este proyecto se distribuye bajo la licencia MIT.
Puedes usarlo, modificarlo y compartirlo con fines académicos o personales.

⭐ Si este proyecto te fue útil, considera dejar una estrella en el repositorio ⭐
