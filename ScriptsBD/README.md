# 🏋️‍♂️ GimnasioLinux – Implementación del Modelo Físico (MySQL)

Este paquete contiene los **scripts SQL** correspondientes a la implementación del **modelo lógico al modelo físico** de la base de datos **GIMNASIOLINUX**, diseñada para la gestión integral de un gimnasio.  

Incluye la creación de tablas, inserción de datos, y consultas de verificación que reflejan la estructura y relaciones del sistema propuesto.

---

## 📘 Contenido del Entregable

### 1️⃣ Scripts de creación de objetos (`01` – `08`)
Cada script define la estructura física de una tabla, incluyendo claves primarias, foráneas, tipos de datos y restricciones de integridad referencial.

| Archivo | Descripción |
|----------|--------------|
| `01_entrenador.sql` | Creación de la tabla **entrenador** y carga de datos iniciales. |
| `02_fisioterapeuta.sql` | Creación de la tabla **fisioterapeuta** con especialidad y licencia. |
| `03_suscripcion.sql` | Creación de la tabla **suscripcion** con fechas, estado y duración. |
| `04_cliente.sql` | Creación de la tabla **cliente**, con relación a **suscripcion**. |
| `05_clase.sql` | Creación de la tabla **clase**, vinculada a un **entrenador**. |
| `06_ingreso.sql` | Creación de la tabla **ingreso**, que relaciona clientes con clases. |
| `07_horario.sql` | Creación de la tabla **horario**, con cupos y horarios por clase. |
| `08_valoracion.sql` | Creación de la tabla **valoracion**, asociada a **cliente** y **fisioterapeuta**. |

---

### 2️⃣ Scripts de inserción de registros
Dentro de cada archivo de tabla (`01` – `08`) se incluyen sentencias `INSERT INTO` con **datos de ejemplo**, cuidadosamente diseñados para:

- Permitir pruebas de relaciones entre entidades.  
- Representar escenarios reales del gimnasio (clases, fisioterapeutas, valoraciones, etc.).  
- Verificar integridad referencial y consistencia de datos.  

---

### 3️⃣ Scripts varios (`09_consultas.sql`)
Contiene las **sentencias SQL de validación y consulta**, útiles para comprobar el correcto funcionamiento de la base de datos una vez implementada:

| Consulta | Descripción |
|-----------|--------------|
| Listado de suscripciones activas | Muestra clientes con membresías vigentes. |
| Horarios de clases de Yoga | Devuelve horarios específicos según clase. |
| Clientes con múltiples clases | Identifica usuarios inscritos en más de una clase. |
| Valoraciones en fecha específica | Filtra registros atendidos por fisioterapeutas. |
| Clientes sin suscripción activa | Muestra usuarios con membresías vencidas. |
| Clases con cupo mayor a 20 | Permite controlar disponibilidad por grupo. |
| Clases largas y con poco cupo | Identifica posibles desequilibrios operativos. |
| Valoraciones pendientes | Visualiza las sesiones aún no completadas. |
| Clientes por fisioterapeuta | Permite analizar carga laboral del personal. |
| Entrenadores por turno | Consulta simple por disponibilidad horaria. |

---

## ⚙️ Instrucciones de Ejecución

1. **Abrir MySQL Workbench** o el cliente CLI preferido.  
2. Crear la base de datos:
   ```sql
   CREATE DATABASE GIMNASIOLINUX;
   USE GIMNASIOLINUX;
   ```
3. **Ejecutar los scripts** en el siguiente orden:
   ```
   01_entrenador.sql
   02_fisioterapeuta.sql
   03_suscripcion.sql
   04_cliente.sql
   05_clase.sql
   06_ingreso.sql
   07_horario.sql
   08_valoracion.sql
   ```
4. Finalmente, correr el archivo:
   ```
   09_consultas.sql
   ```
   para verificar la integridad y funcionamiento del modelo.

---

## 💾 Requisitos Técnicos

- **RDBMS:** MySQL 8.0 o superior  
- **Sistema Operativo sugerido:** Ubuntu 24.04 LTS (máquina virtual configurada con NAT, puerto 3306)
- **Cliente recomendado:** MySQL Workbench  
- **Codificación:** UTF-8  

---

## 👨‍💻 Autor

**Proyecto Académico:** *Implementación del Modelo Físico – GimnasioLinux*  
**Desarrollado por:** [Tu nombre aquí]  
**Fecha:** Noviembre de 2025  

---

## 📁 Estructura del Paquete

```
gimnasio_scripts.zip
├── 01_entrenador.sql
├── 02_fisioterapeuta.sql
├── 03_suscripcion.sql
├── 04_cliente.sql
├── 05_clase.sql
├── 06_ingreso.sql
├── 07_horario.sql
├── 08_valoracion.sql
└── 09_consultas.sql
```

---

> 💡 **Nota:** Se recomienda ejecutar los scripts en el orden indicado para evitar errores de dependencias entre claves foráneas.
