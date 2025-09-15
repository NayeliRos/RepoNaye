# karate-usuarios

Proyecto de pruebas automatizadas de API para gestión de usuarios usando Karate DSL.

## Estructura del proyecto

```
karate-usuarios/
├── pom.xml
├── src/
│   └── test/
│       ├── java/
│       │   └── usuarios/
│       │       └── UsuariosRunner.java
│       └── resources/
│           ├── karate-config.js
│           ├── helpers/
│           │   └── data-generator.js
│           └── usuarios/
│               └── features/
│                   └── User/
│                       ├── deleteUser_by_id.feature
│                       ├── getUser_by_id.feature
│                       ├── getUser.feature
│                       ├── postUser.feature
│                       ├── putUser_by_id.feature
│                       └── helpers/
│                           └── createRandomUser.feature
└── target/
    └── karate-reports/
```

## ¿Qué es Karate?
Karate es un framework open source para pruebas automatizadas de APIs REST, SOAP y UI, que permite escribir escenarios en lenguaje Gherkin y soporta JavaScript para lógica avanzada.

## Ejecución de pruebas

1. Instala Java 8+ y Maven.
2. Ejecuta las pruebas con:

```sh
mvn test
```

3. Los reportes se generan en `target/karate-reports/`.

## Estructura de features
- **postUser.feature**: Alta de usuario y validaciones de email.
- **putUser_by_id.feature**: Actualización de usuario por ID.
- **getUser_by_id.feature**: Consulta de usuario por ID.
- **getUser.feature**: Listado de usuarios.
- **deleteUser_by_id.feature**: Eliminación de usuario por ID.
- **helpers/data-generator.js**: Generador de datos aleatorios reutilizable. //prueba

## Uso de helpers JS
Puedes importar funciones JS en tus features así:

```gherkin
* def helper = call read('classpath:helpers/data-generator.js')
* def usuario = helper.generarUsuario()
```

## Requisitos
- Java 8+
- Maven 3.6+

## Autor
- Proyecto de ejemplo para pruebas API con Karate DSL.
