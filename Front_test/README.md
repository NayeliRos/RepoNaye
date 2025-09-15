# 📑 Tabla de Contenidos

1.  [Acerca del Proyecto](#acerca-del-proyecto)\
2.  [Construido Con](#construido-con)\
3.  [Comenzando](#comenzando)
    -   [Requisitos Previos](#requisitos-previos)\
    -   [Instalación](#instalación)\
4.  [Uso](#uso)\
5.  [Estructura del Proyecto](#estructura-del-proyecto)\
6.  [Escenarios de Prueba](#escenarios-de-prueba)\
7.  [Credenciales](#credenciales)\
8.  [Contribución](#contribución)\
9.  [Licencia](#licencia)

------------------------------------------------------------------------

## Acerca del Proyecto

Este repositorio contiene la suite de automatización QA para la
aplicación **SauceDemo**.\
Se utiliza **Cucumber (Gherkin)** para definir los escenarios de prueba
y **Playwright** para ejecutarlos.\
Se implementa el patrón de diseño **Page Object Model (POM)** para
mejorar el mantenimiento del código.

------------------------------------------------------------------------

## Construido Con

-   Node.js\
-   Cucumber.js\
-   Playwright\
-   TypeScript\
-   Page Object Model (POM)

------------------------------------------------------------------------

## Comenzando

### Requisitos Previos

-   Node.js v20 o superior
-   npm\
-   Visual Studio Code (recomendado)

### Instalación

1.  Clonar el repositorio:

    ``` bash
    git clone <AUN NO SUBIDO>
    ```

2.  Entrar a la carpeta del proyecto:

    ``` bash
    cd PruebaNaye/SauceDemo
    ```

3.  Instalar dependencias:

    ``` bash
    npm install
    ```

------------------------------------------------------------------------

## Uso

Para ejecutar todas las pruebas:

``` bash
npm test
```

En caso de presentar el error de permisos en PowerShell:

Ejecutar el siguiente comando para permitir correr los tests con un
permiso temporal (sesión activa):

``` powershell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
```

------------------------------------------------------------------------

## Estructura del Proyecto

    PruebaNaye/
     ├── features/           # Archivos .feature en Gherkin
     ├── steps/              # Definiciones de pasos (step definitions)
     ├── pages/              # Page Object Model — clases por página
     ├── package.json
     └── README.md

------------------------------------------------------------------------

## Escenarios de Prueba

-   Inicio de sesión exitoso y fallido\
-   Agregar productos al carrito\
-   Ver carrito con productos\
-   Checkout completo\
-   Manejo de usuarios bloqueados

------------------------------------------------------------------------

## Credenciales

  Usuario           Contraseña     Rol
  ----------------- -------------- -------------------
  standard_user     secret_sauce   Usuario normal
  locked_out_user   secret_sauce   Usuario bloqueado

------------------------------------------------------------------------

## Contribución

Si deseas aportar o mejorar el proyecto:\
1. Haz un fork del repositorio.\
2. Crea una rama nueva:\
`bash    git checkout -b feature/nombre-de-tu-feature` 3. Realiza tus
cambios.\
4. Haz commit de tus cambios:\
`bash    git commit -am "Añadir nueva funcionalidad"` 5. Haz push a tu
rama:\
`bash    git push origin feature/nombre-de-tu-feature` 6. Abre un **Pull
Request**.

------------------------------------------------------------------------

