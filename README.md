Plataforma de Recursos para Bootcamp (P6R) 🚀
📅 Última actualización: 15 de marzo de 2025 👩‍💻 Propiedad de: Erika Montesinos Corell

🌟 Descripción del Proyecto
La Plataforma de Recursos para Bootcamp (P6R) es una solución web centralizada diseñada para apoyar a estudiantes, programadores junior e instructores en su aprendizaje y colaboración. Ofrece recursos educativos confiables y organizados, estructurados en una interfaz moderna y amigable.

Los estudiantes podrán acceder a tutoriales, ejercicios prácticos, ejemplos de código y un banco de videos relacionados con tecnologías clave utilizadas en desarrollo full stack. Además, se fomenta la colaboración mediante el intercambio de recursos, comentarios y valoraciones.

🎯 Objetivo principal: Mejorar la experiencia de aprendizaje, reducir la curva de aprendizaje y crear una comunidad activa donde el conocimiento fluya de manera estructurada y efectiva.

👥 Equipo de Desarrollo
ACE-Code Backend
Erica Montesinos - GitHub: erikamc99

Carlota Menéndez Landa - GitHub: Carlotaml21

Ana Belén Hernández - GitHub: AnaBHernandez

ACE-Code Frontend
Ayelén Marcos Nacht - GitHub: Ayuik

Alberto - GitHub: Algama17

Eva - GitHub: Emagmunioz

📚 Funcionalidades Principales
Frontend
✔️ Página principal con información sobre el bootcamp. ✔️ Registro e inicio de sesión de usuarios. ✔️ Panel de usuario con acceso a:

Documentación con ejemplos de código.

Ejercicios prácticos organizados por temas.

Banco de videos educativos. ✔️ Sistema de subida de recursos (archivos o enlaces). ✔️ Diseño responsive para adaptarse a cualquier dispositivo. ✔️ Sistema de comentarios y valoraciones.

Backend
🔹 API REST para gestionar usuarios y recursos. 🔹 Base de datos H2 para almacenar información de usuarios y recursos. 🔹 Gestión de comentarios y valoraciones de recursos. 🔹 Servicios para subida de archivos y enlaces externos.

Testing
🛠️ Pruebas unitarias con JUnit para validar funcionalidades clave. 🛠️ Pruebas de integración con Hamcrest para garantizar el correcto funcionamiento de la API REST. 🛠️ Cobertura unitaria actual: 46%, en expansión constante.

🔑 MVP (Producto Mínimo Viable)
La primera versión de la plataforma incluye:

Acceso a recursos organizados por categorías para usuarios registrados.

Subida y visualización de archivos y enlaces.

Sistema de comentarios y valoraciones.

Página principal con información básica para usuarios no registrados.

Acceso exclusivamente online, sin posibilidad de descarga.

📈 Criterios de Éxito
✔️ Plataforma completamente funcional con gestión de usuarios y recursos. ✔️ Interfaz moderna, intuitiva y accesible. ✔️ Backend escalable, seguro y eficiente. ✔️ Validación de calidad mediante pruebas unitarias e integración. ✔️ Feedback constante para mejoras continuas.

🛠️ Tecnologías Usadas
Frontend
React, HTML, CSS, JavaScript

Backend
Java con Spring Boot

Base de Datos
H2 (base de datos en memoria)

Testing
JUnit, Hamcrest

📂 Estructura del Proyecto
plaintext
/src
  ├── main
  │   ├── java/com/p6r           # Código fuente del backend
  │   ├── resources              # Configuración y archivos estáticos
  └── test                       # Tests unitarios y de integración
/frontend                        # Código fuente del frontend
⚙️ Instalación y Configuración
Requisitos Previos
JDK 17+

Maven 3.6+

Node.js y npm (para el frontend)

Pasos de Instalación
Clona el repositorio:

bash
git clone <URL-DEL-REPOSITORIO>
cd <NOMBRE-DEL-REPOSITORIO>
Configura el archivo application.properties en el backend y .env en el frontend.

Compila y ejecuta el backend:

bash
mvn clean install
mvn spring-boot:run
Inicia el frontend:

bash
cd frontend
npm install
npm start
Accede a la aplicación en http://localhost:3000.

🤝 Cómo Contribuir
Haz un fork del repositorio.

Crea una rama (git checkout -b nueva-funcionalidad).

Realiza tus cambios y súbelos (git push origin nueva-funcionalidad).

Abre un pull request para revisión.

📝 Licencia
Este proyecto es propiedad de Erika Montesinos Corell y su equipo. Todos los derechos reservados. No está permitida la distribución sin previa autorización.