# **EVC OFFSHORE – RECOLECTOR**

## Introducción 🚀


Vinculación es una aplicación que se encarga de realizar la inscripción preliminar para solicitar una cuenta de ahorro y/o corriente. Estas cuentas están dirigidas a clientes colombianos que quieran abrir sus cuentas en USD.

Las pruebas de esta aplicación se ejecutan en la siguiente web: [FRONT DE RECOLECCIONES](https://frc-fe-qa.apps.ambientesbc.com/).


## Pre requisitos 📋
- Java version 11, JDK (variables de entorno configuradas).
- Eclipse IDE ó IntelliJ IDEA (version 2023).
- Gradle version 8.9 ó más alta (variables de entorno configuradas).
- Cucumber for Java Plugin (Versión actualizada).
- Gherkin Plugin (Versión actualizada).
- ChromeDriver (Versión actualizada) para ejecuciones locales de automatizaciones.
- ChromeDriver (Versión actualizada) para la ejecución del RM Pipeline (el navegador web VDI Chrome donde se ejecuta el Pipeline tiene la versión equivalente).

## Navegador web  🌐
La automatización actualmente se ejecuta en el siguiente navegador:
- Google Chrome Versión 124.0.6367.209.

## Instalación ⚙️
- Para clonar este repositorio localmente, se debe ejecutar el siguiente comando:
```clon de git https://grupobancolombia.visualstudio.com/Vicepresidencia%20Servicios%20de%20Tecnolog%C3%ADa/_git/NU5490001_Front_De_Recoleccion_FE_Test```.
- Importar el proyecto desde Eclipse o IntelliJ IDE bajo la estructura de un proyecto Gradle existente ó nuevo.
- Configurar la biblioteca del sistema JRE con JavaSE-11.
- Configurar la codificación a UTF-8 del proyecto una vez importado.

## Comando para ejecución ▶️
- El proyecto se puede ejecutar desde la consola con el siguiente comando:
```gradle clean test aggregate```.
- The Serenity report will be generated in the folder ``/target/site/serenity/`` located in the root folder of each automation project.

## Construcción 🛠
La automatización se desarrolla con:
- BDD (Behavior-Driven Development) - Estrategia de desarrollo.
- Patrón de guión - Patrón de diseño que aplica principios SÓLIDOS.
- Gradle - Gerente de proyectos y dependencias.
- Selenium Web Driver - Herramienta para automatizar acciones en navegadores web.
- Cucumber - Framework para automatizar pruebas BDD.
- Serenity BDD - Framework, biblioteca de código abierto para generación de informes.
- Gherkin: lenguaje específico de dominio (DSL) legible para empresas.

## Convención de programación 🎨
Los siguientes estilos de escritura se utilizan en las automatizaciones:
- Variables y funciones: Lower Camel Case. Ejemplo: `nomenclaturaEjemplo`.
- Nombres de clase: PascalCase o Upper Camel Case. Ejemplo: `EjemploDeNomenclatura`.
- Nombres de funciones: Snake Case. Ejemplo: `nomenclatura_ejemplo`.

## Versionado  🔀
Para el control de versiones se utiliza Git, aplicando la metodología de Desarrollo Basado en Trunk.

## Carpeta "Documentos de Pruebas" 📑
---
IEs la carpeta que contiene los modelos de transacciones automatizadas de Bizagi y la estrategia de prueba global.

## NU5490001_Front_De_Recoleccion_Test 🎬
---
Es la carpeta que contiene el proyecto de prueba automatizado.
