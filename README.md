# RotomPedia Backend - Microservicio

Microservicio desarrollado en Kotlin con Spring Boot. Este componente centraliza la gestión de datos y está configurado para desplegarse de forma automática mediante contenedores.

## Estrategia de Ramas (GitFlow)

Se adoptó **GitFlow** como modelo de ramificación para mantener un flujo de trabajo ordenado y evitar conflictos entre colaboradores. Esta estrategia permite separar claramente el código en desarrollo (`develop`) del código estable y listo para producción (`main`).

* `main`: Rama de producción. Solo se actualiza mediante Pull Requests aprobados.
* `develop`: Rama de integración donde converge el trabajo del equipo.
* `feature/<nombre>`: Ramas para el desarrollo de nuevas funcionalidades (ej: `feature/dockerizacion`). Se crean desde `develop` y se integran de vuelta a `develop`.
* `hotfix/<nombre>`: Ramas para la corrección urgente de errores en producción.

## Convenciones de Commits

Para mantener un historial de cambios claro y legible, se utiliza el estándar _Conventional Commits_:

* `feat:` Incorporación de nuevas funcionalidades (ej: `feat: agregar Dockerfile`).
* `fix:` Corrección de errores (ej: `fix: corregir conexión a BD`).
* `chore:` Tareas de mantenimiento o actualización de dependencias (ej: `chore: actualizar dependencias en Gradle`).

## Reglas del Equipo

1. **Está prohibido hacer push directo a `main` o `develop`.**
2. Todo cambio debe integrarse a través de **Pull Requests (PR)**.
3. Cada PR requiere revisión y aprobación de otro miembro del equipo (Code Review) antes de poder hacer Merge.
4. El pipeline de CI en GitHub Actions debe completarse exitosamente (Build, Tests, Seguridad y Docker) como requisito previo al Merge.

## Estructura del Proyecto

* `src/main/kotlin/...`: Código fuente de la aplicación.
* `.github/workflows/`: Configuración del flujo de automatización (`ci.yml`).
* `Dockerfile` y `docker-compose.yml`: Archivos para la construcción de la imagen y el levantamiento del entorno mediante contenedores.

## Trazabilidad, Calidad y Seguridad (CI/CD)

Se implementó un flujo de automatización en GitHub Actions que se ejecuta en cada Pull Request, cubriendo las siguientes etapas:

1. **Trazabilidad:** La estrategia de ramas y las convenciones de commits permiten asociar cada versión del software con el commit que la originó, garantizando un historial auditable.
2. **Pruebas automáticas:** El pipeline levanta un entorno con Ubuntu y Java 17, y ejecuta los tests unitarios mediante `./gradlew build`. Cualquier fallo bloquea automáticamente el PR e impide la integración del código defectuoso.
3. **Seguridad (DevSecOps):** Se integraron Snyk y SonarCloud al pipeline para realizar análisis estático de código y escaneo de dependencias, detectando vulnerabilidades antes de que el código llegue a la rama principal.
4. **Despliegue y Orquestación:** El pipeline automatiza la construcción de la imagen Docker (usando Eclipse Temurin) y verifica la orquestación entre la aplicación y la base de datos MySQL mediante `docker compose up -d`.

## Uso de Inteligencia Artificial (Gemini)

Se utilizó Gemini como apoyo técnico durante distintas etapas del desarrollo:

- Elaboración y depuración del script de GitHub Actions (`ci.yml`) para garantizar la correcta ejecución de Gradle.
- Resolución de conflictos de fusión (Merge Conflicts) y errores durante operaciones de `git push`.
- Diagnóstico y solución de incompatibilidades de dependencias entre Gradle 8.7, SpringMockk y MySQL.
- Actualización de la imagen base del `Dockerfile` y ajuste del comando de Docker Compose en el pipeline.

## Conclusiones y Reflexiones Individuales

**Reflexión de Matias Espinoza:**
Este proyecto me permitió profundizar en el trabajo colaborativo y en la reutilización de componentes desarrollados previamente. A través de él, logré integrar una aplicación web existente con un microservicio nuevo, evitando la duplicación de esfuerzos y aprovechando la modularidad como ventaja concreta del enfoque adoptado.

**Reflexión de Vicente Placencia:**
Gracias a este proyecto, logré avanzar como desarrollador y ver nuevas formas de usar ciertas aplicaciones y profundizar el uso de Github como herramienta, lo cual me servira mucho en futuros proyectos. Es importante recalcar que la buena comunicacion y participacion con mi compañero es muy importante y le da una gran experiencia a la forma en que desarrollamos esto.
