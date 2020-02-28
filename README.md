# Moodle - Server

Es un sistema tipo Moodle programado en la arquitectura *Cliente-Servidor* con Sockets el envio de informacion se hace por medio de *Unicast* y *Multicast*, su objetivo es poder resolver examenes de manera colaborativa con preguntas que se cargan por medio de archivos *.txt* que se encuentran en la ruta ***/evaluations/new*** una vez se termina el hilo de ejecucion del programa o los participantes terminen todas las preguntas cargadas. Los examenes se califican del banco de preguntas y se  guardan en la ruta ***/evaluations/qualification*** para su posterior revision por parte del docente.

---
<u><h3> Obtener proyecto</u></h3>

Puedes obtener el proyecto de dos formas:
```
- git clone https://github.com/AndresDFX/Moodle-Server.git
- En la parte superior del proyecto “Download ZIP”.
```
---
<u><h3>Prerrequisitos</h3></u>

• Sistema operativo Windows, Linux  o MAC
• IDE NetBeans 8.1 o superior
• Máquina virtual Java JDK 1.8 para compilar

---	
<u><h3>Guía de instalación</u></h3>

**1.**	Debemos importar el proyecto Netbeans o cargar las clases en su IDE de preferencia

**2.**	En net beans debemos resolver las dependencias de las librerías dando clic en “Resolve Problems Project”

<img src="/screenshots/resolveproblems_netbeans.png"> 
		
**3.**	Seleccionamos una a una las librerías de la carpeta “libraries”
	
<img src="/screenshots/listlibrary_netbeans.png">

**4.**	Por ultimo ejecutamos “Clean and Build”

<img src="/screenshots/build_netbeans.png">


***Nota:*** Es necesario que se ejecute de 2 a 4 clientes [Moodle-Client](https://github.com/AndresDFX/Moodle-Client.git), se defina el tiempo y se elija un archivo.txt para poder que el examen empiece.

---
<u><h3>Deployment</u></h3> 

**1.**	Para ingresar al Rol del admin las credenciales son admin:123.
**2.**	Verificar que las carpetas con los examenes tenga permisos por parte del OS.

---

<u><h3>Construido con</u></h3>

* [Netbeans](https://netbeans.org/) - IDE
* [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html) – Biblioteca grafica
* [Componentes RS](https://github.com/RojeruSan/Componentes-RS-1.0) – Libreria grafica
---

<u><h3>Versionado</u></h3>
Usamos [Git](https://git-scm.com/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/AndresDFX/Moodle-Server/tags).

---
<u><h3>Autores</u></h3>

- **Andres Castaño** ([AndresDFX](https://github.com/AndresDFX)) - *Analisis y Desarrollo* 

---
<u><h3>Licencia</u></h3> 

Este proyecto está bajo la Licencia GNU General Public License 3.0 - mira el archivo [LICENSE.md](LICENSE.md) para detalles.