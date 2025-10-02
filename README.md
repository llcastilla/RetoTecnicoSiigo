# Reto Técnico – Automatización de Pruebas E2E y Backend

Este proyecto contiene el desarrollo de un reto técnico orientado a la automatización de pruebas tanto de **Front-End (UI)** como de **Back-End (API)**, implementando el patrón **Screenplay** con el framework **Serenity BDD**.

El objetivo principal es demostrar las buenas prácticas en la construcción de pruebas automáticas, asegurando **mantenibilidad, legibilidad y escalabilidad** de los casos de prueba.

---

## 🚀 Tecnologías utilizadas

- **Lenguaje:** Java 17
- **Framework:** Serenity BDD
- **Patrón de diseño:** Screenplay Pattern
- **Gestión de dependencias:** Gradle
- **Front-End Testing:** Serenity Screenplay con Selenium WebDriver
- **Back-End Testing:** Serenity Rest (RestAssured + Serenity)
- **Ejecución de pruebas:** JUnit / Cucumber
- **Reportes:** Serenity Reports

---

## 📌 Estructura del proyecto

El proyecto está dividido en dos módulos principales:

1. **Pruebas de Front-End (UI)**
    - Automatización E2E con Selenium y Serenity Screenplay.
    - Se construyen **Tasks, Interactions y Questions** para modelar el comportamiento de los usuarios.
    - Se definen escenarios en **Gherkin (Cucumber)** para mantener pruebas legibles y fáciles de entender.

2. **Pruebas de Back-End (API)**
    - Automatización de servicios REST utilizando Serenity Rest.
    - Validación de códigos de estado HTTP y respuestas JSON.
    - Escenarios definidos en **Gherkin (Cucumber)** para documentar la intención de las pruebas.

---

## 🧪 Ejecución de pruebas

### 🔹 Pruebas de UI (Front-End)
Ejecutar los escenarios definidos en el módulo de **UI**:
```bash
./gradlew clean test -i
```

```cmd
gradle clean test -i
```

### 🔹 Pruebas de API (Back-End)
Ejecutar los escenarios definidos en el módulo de **API**:
```bash
./gradlew clean test -i
```

```cmd
gradle clean test -i
```

### 🔹 Reporte Serenity
Al finalizar la ejecución se genera el reporte Serenity en:
```
target/site/serenity/index.html
```

---

## 📂 Organización de carpetas

```bash
src
 └── test
      ├── java
      │    ├── tasks        # Acciones de alto nivel
      │    ├── interactions # Acciones detalladas del actor
      │    ├── questions    # Validaciones y aserciones
      │    ├── models       # Representación de datos
      │    └── runners      # Configuración de ejecución
      └── resources
           └── features     # Escenarios en Gherkin
```

---

## ✅ Alcance del reto

- **Front-End (UI):**
    - Escenarios E2E representando el flujo de usuario en la aplicación.
    - Validaciones visuales y funcionales.

- **Back-End (API):**
    - Escenarios de prueba sobre endpoints REST.
    - Casos de éxito y error (códigos de estado, estructura de la respuesta, mensajes).

---

## 📊 Resultados esperados

- Pruebas claras y fáciles de entender por cualquier miembro del equipo.
- Reportes detallados en Serenity para analizar resultados.
- Arquitectura basada en **Screenplay**, promoviendo reutilización de código.  
