# Gestor de Campañas de donacion de sagre

## Descripcion

Sistema desarrollado en Java para la gestión de campañas de donación de sangre. El sistema permite administrar campañas, registrar donantes y consultar la información asociada a las distintas campañas de donación.

El software busca facilitar la organización de la información relacionada con las campañas y sus donantes, proporcionando una interfaz de interacción mediante una consola y una interfaz gráfica.

## Funcionalidades

* Crear campañas de donación de sangre.
* Gestionar campañas fijas y móviles.
* Modificar informacion de las campañas.
* Eliminar campañas.
* Registrar donantes.
* Modificar y eliminar donantes.
* Asociar donantes a campañas.
* Consultar información de campañas.
* Consultar información de donantes.
* Gestionar los distintos tipos de sangre mediante un `enum`.
* Almacenar y recuperar información mediante archivos CSV.
* Utilizar el sistema mediante consola o interfaz gráfica.

## Estructura del proyecto

El proyecto se encuentra organizado en distintos paquetes según las responsabilidades de cada componente.

### `gestorcampania`

Contiene las clases principales del dominio y la gestión del sistema.

* `GestorCampania`: administra las campañas existentes.
* `Campania`: clase abstracta que representa una campaña de donación.
* `CampaniaFija`: representa una campaña realizada en una ubicación fija.
* `CampaniaMovil`: representa una campaña que puede realizarse en distintas ubicaciones.
* `Donante`: representa a un donante registrado.
* `Sangre`: enum que representa los distintos tipos de sangre.
* `ControladorCampania`: gestiona las operaciones relacionadas con las campañas.
* `ControladorDonantes`: gestiona las operaciones relacionadas con los donantes.
* `CSV`: proporciona funcionalidades relacionadas con el almacenamiento de información en archivos CSV.

### `consola`

Contiene los componentes encargados de la interacción con el usuario mediante la terminal.

### `Vent`

Contiene los componentes relacionados con la interfaz gráfica del sistema.

### `herramientas`

Contiene clases auxiliares utilizadas para facilitar determinadas operaciones del sistema, como la lectura y validación de datos ingresados por el usuario.

## Tecnologías utilizadas

* **Java**
* **Git**
* **GitHub**
* **Java Collections Framework**
* Archivos **CSV** para almacenamiento de información

## Modelo de campañas

El sistema contempla dos tipos de campañas:

### Campaña fija

Una campaña fija se realiza en una única ubicación determinada.

### Campaña móvil

Una campaña móvil puede contar con múltiples ubicaciones, permitiendo gestionar campañas que se realizan en distintos lugares.

Ambos tipos de campaña heredan de la clase abstracta `Campania`.

## Ejecución

1. Clonar el repositorio.
2. Abrir el proyecto en un entorno de desarrollo compatible con Java.
3. Compilar el proyecto.
4. Ejecutar la clase principal `GestorCampania`.
5. Seleccionar la modalidad de interacción disponible.

## Control de versiones

El proyecto utiliza **Git** para el control de versiones y **GitHub** como repositorio remoto.

## Autores

* Nicolás Caniguante
* Nicolás Castellano
* Benjamín Concha
* Lucas Salamanca
