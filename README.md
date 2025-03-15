<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plataforma de Recursos para Bootcamp (P6R)</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
            color: #333;
        }
        
        h1, h2, h3 {
            color: #2c3e50;
        }
        
        h1 {
            border-bottom: 4px solid #3498db;
            display: inline-block;
        }
        
        .emoji {
            margin: 0 5px;
        }
        
        .team-member {
            margin: 10px 0;
        }
        
        .feature-list {
            margin-left: 20px;
        }
        
        .code-block {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            margin: 10px 0;
            font-family: monospace;
        }
        
        pre {
            white-space: pre-wrap;
            word-wrap: break-word;
        }
    </style>
</head>
<body>
    <div class="content">
        <h1>Plataforma de Recursos para Bootcamp (P6R) 🚀</h1>
        
        <div class="metadata">
            <span>📅 Última actualización: 15 de marzo de 2025</span>
            <span>👩‍💻 Propiedad de: Erika Montesinos Corell</span>
        </div>

        <h2>🌟 Descripción del Proyecto</h2>
        <p>La Plataforma de Recursos para Bootcamp (P6R) es una solución web centralizada diseñada para apoyar a estudiantes, 
           programadores junior e instructores en su aprendizaje y colaboración. Ofrece recursos educativos confiables y 
           organizados, estructurados en una interfaz moderna y amigable.</p>

        <h2>🎯 Objetivo principal:</h2>
        <p>Mejorar la experiencia de aprendizaje, reducir la curva de aprendizaje y crear una comunidad activa donde el 
           conocimiento fluya de manera estructurada y efectiva.</p>

        <h2>👥 Equipo de Desarrollo</h2>
        <div class="team-section">
            <h3>ACE-Code Backend</h3>
            <div class="team-member">Erica Montesinos - GitHub: erikamc99</div>
            <div class="team-member">Carlota Menéndez Landa - GitHub: Carlotaml21</div>
            <div class="team-member">Ana Belén Hernández - GitHub: AnaBHernandez</div>

            <h3>ACE-Code Frontend</h3>
            <div class="team-member">Ayelén Marcos Nacht - GitHub: Ayuik</div>
            <div class="team-member">Alberto - GitHub: Algama17</div>
            <div class="team-member">Eva - GitHub: Emagmunioz</div>
        </div>

        <h2>📚 Funcionalidades Principales</h2>
        
        <h3>Frontend</h3>
        <ul class="feature-list">
            <li>Página principal con información sobre el bootcamp</li>
            <li>Registro e inicio de sesión de usuarios</li>
            <li>Panel de usuario con acceso a:
                <ul>
                    <li>Documentación con ejemplos de código</li>
                    <li>Ejercicios prácticos organizados por temas</li>
                    <li>Banco de videos educativos</li>
                </ul>
            </li>
            <li>Sistema de subida de recursos (archivos o enlaces)</li>
            <li>Diseño responsive para adaptarse a cualquier dispositivo</li>
            <li>Sistema de comentarios y valoraciones</li>
        </ul>

        <h3>Backend</h3>
        <ul class="feature-list">
            <li>API REST para gestionar usuarios y recursos</li>
            <li>Base de datos H2 para almacenar información de usuarios y recursos</li>
            <li>Gestión de comentarios y valoraciones de recursos</li>
            <li>Servicios para subida de archivos y enlaces externos</li>
        </ul>

        <h3>Testing</h3>
        <ul class="feature-list">
            <li>Pruebas unitarias con JUnit para validar funcionalidades clave</li>
            <li>Pruebas de integración con Hamcrest para garantizar el correcto funcionamiento de la API REST</li>
            <li>Cobertura unitaria actual: 46%, en expansión constante</li>
        </ul>

        <h2>🔑 MVP (Producto Mínimo Viable)</h2>
        <ul class="feature-list">
            <li>Acceso a recursos organizados por categorías para usuarios registrados</li>
            <li>Subida y visualización de archivos y enlaces</li>
            <li>Sistema de comentarios y valoraciones</li>
            <li>Página principal con información básica para usuarios no registrados</li>
            <li>Acceso exclusivamente online, sin posibilidad de descarga</li>
        </ul>

        <h2>📈 Criterios de Éxito</h2>
        <ul class="feature-list">
            <li>Plataforma completamente funcional con gestión de usuarios y recursos</li>
            <li>Interfaz moderna, intuitiva y accesible</li>
            <li>Backend escalable, seguro y eficiente</li>
            <li>Validación de calidad mediante pruebas unitarias e integración</li>
            <li>Feedback constante para mejoras continuas</li>
        </ul>

        <h2>🛠️ Tecnologías Usadas</h2>
        <h3>Frontend</h3>
        <ul class="feature-list">
            <li>React, HTML, CSS, JavaScript</li>
        </ul>

        <h3>Backend</h3>
        <ul class="feature-list">
            <li>Java con Spring Boot</li>
        </ul>

        <h3>Base de Datos</h3>
        <ul class="feature-list">
            <li>H2 (base de datos en memoria)</li>
        </ul>

        <h3>Testing</h3>
        <ul class="feature-list">
            <li>JUnit, Hamcrest</li>
        </ul>

        <h2>📂 Estructura del Proyecto</h2>
        <pre class="code-block">
/src
  ├── main
  │   ├── java/com/p6r           # Código fuente del backend
  │   ├── resources              # Configuración y archivos estáticos
  └── test                       # Tests unitarios y de integración
/frontend                        # Código fuente del frontend</pre>

        <h2>⚙️ Instalación y Configuración</h2>
        <h3>Requisitos Previos</h3>
        <ul class="feature-list">
            <li>JDK 17+</li>
            <li>Maven 3.6+</li>
            <li>Node.js y npm (para el frontend)</li>
        </ul>

        <h3>Pasos de Instalación</h3>
        <pre class="code-block" lang="bash">git clone <URL-DEL-REPOSITORIO>
cd <NOMBRE-DEL-REPOSITORIO>

Configura el archivo application.properties en el backend y .env en el frontend.

Compila y ejecuta el backend:
mvn clean install
mvn spring-boot:run

Inicia el frontend:
cd frontend
npm install
npm start

Accede a la aplicación en http://localhost:3000.</pre>

        <h2>🤝 Cómo Contribuir</h2>
        <steps>
            <step number="1">
                <title>Haz un fork del repositorio</title>
            </step>
            <step
            <step