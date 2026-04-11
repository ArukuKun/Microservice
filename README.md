# RotomPedia Backend - Microservicio

Microservicio desarrollado en Kotlin con Spring Boot para la gestión de datos, preparado para un entorno de despliegue automatizado.

## Estrategia de Ramificación (GitFlow)
Hemos seleccionado **GitFlow** como nuestra estrategia de ramificación. 
**Justificación:** Esta metodología nos permite aislar el trabajo en progreso (`develop`) del código listo para producción (`main`), lo cual es ideal para mantener la estabilidad del microservicio mientras desarrollamos nuevas integraciones (como Docker y CI/CD). Además, facilita la colaboración al definir reglas claras para ramas temporales (`feature/` y `hotfix/`).

### Naming de Ramas
* `main`: Contiene el código estable y funcional (Producción).
* `develop`: Rama de integración principal. Aquí se une el trabajo de todos.
* `feature/<nombre-descriptivo>`: Ramas para nuevas funcionalidades (Ej: `feature/dockerizacion`). Nacen de `develop` y se unen a `develop`.
* `hotfix/<nombre-descriptivo>`: Para resolver errores críticos en producción (Ej: `hotfix/documentacion-devops`). Nacen de `main` y se unen a `main` y `develop`.

## Convenciones de Commits
Utilizamos _Conventional Commits_ para mantener un historial trazable:
* `feat:` Para nuevas funcionalidades (ej. `feat: agregar Dockerfile`).
* `fix:` Para solución de errores (ej. `fix: corregir conexión a BD`).
* `chore:` Para tareas de mantenimiento o actualizaciones (ej. `chore: actualizar dependencias`).

## Flujos de Merge y Estrategias de Revisión
1. **Prohibido hacer push directo a `main` o `develop`.**
2. Todo código debe integrarse mediante **Pull Requests (PR)**.
3. Se requiere la revisión y aprobación de al menos 1 compañero (Code Review) antes de realizar el "Merge pull request".
4. El pipeline de CI (GitHub Actions) debe pasar exitosamente (Build & Test) antes de permitir el merge.

## Estructura de Carpetas
* `src/main/kotlin/...`: Código fuente del microservicio (Controladores, Repositorios, Entidades).
* `.github/workflows/`: Archivos de configuración para automatización CI/CD.
* `Dockerfile` / `docker-compose.yml`: Archivos para orquestación y despliegue local simulado.

* ## Automatización CI/CD (GitHub Actions)
Para automatizar la integración continua, configuramos un pipeline básico en `.github/workflows/ci.yml`. Su rol principal dentro del proceso CI/CD es garantizar que todo el código nuevo sea válido antes de integrarse. Cada vez que hacemos un *push* a `develop` o un *Pull Request* a `main`, este flujo levanta un entorno virtual (Ubuntu), instala Java 17, compila el código fuente y ejecuta las pruebas automáticas usando `./gradlew build`. Si el código falla, el Pull Request se bloquea, asegurando la calidad de nuestra rama principal.

## Declaración de uso de Inteligencia Artificial
Durante el desarrollo de esta evaluación, se utilizó IA (Gemini) como apoyo para:
- Corregir el script de GitHub Actions (`ci.yml`) para asegurar la correcta instalación de Java y ejecución de Gradle.
- Guía paso a paso para resolver errores en consola al subir ramas (errores de refspec en git push).

## Conclusiones y Reflexiones Individuales
**Reflexión de Matias Espinoza:**
Aprendi a trabajar enm equipo y a reutilizar contenido pasado hace tiempo. Gracias a este proyecto pude completar una aplicacion web que habiamos creado con un amigo y a reutilizarlo para darle un ueso mas, poder utilizar otr microservicio sin necesidad de crear uno nuevo es Goty.

**Reflexión de [Nombre de tu compañero/a]:**
