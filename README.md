# Conversor de Monedas

Este proyecto es un conversor de monedas que utiliza la API ExchangeRate para obtener tasas de cambio actualizadas.
Está diseñado como parte del desafío de la especialización en Back-End de Alura Latam.

## Estructura del Proyecto

El proyecto tiene un package "com.alura.conversordemonedas" que tiene las siguientes clases:

1. **Clase Principal (main)**:
   Punto de entrada de la aplicación. Muestra un menú al usuario para seleccionar opciones de conversión de monedas.
   Responsabilidades: Captura las entradas del usuario, gestiona la lógica de conversión y llama a otros métodos según sea necesario.
2. **Clase ConversorAPI**:
   Interactúa con la API de ExchangeRate para obtener tasas de cambio.
   Responsabilidades: Configura la API Key desde una variable de entorno, realiza solicitudes HTTP para obtener tasas de cambio y proporciona métodos para convertir monedas.
3. **Clase Búsqueda**:
   Representa una búsqueda de conversión de moneda.
   Responsabilidades: Almacena la moneda de origen, la cantidad, la moneda de destino, la tasa de cambio y el resultado de la conversión.
4. **Clase HistorialDeBusqueda**:
   Maneja el historial de conversiones y lo guarda en un archivo JSON.
   Responsabilidades: Mantiene una lista de objetos Busqueda, serializa esta lista a formato JSON y la guarda en un archivo historial.json.

## Utiliza las siguientes bibliotecas y herramientas:

- **Java Collections**: Para manejar listas y colecciones de datos.
- **Gson**: Para convertir objetos Java a JSON y viceversa.
- **JsonObject**, **JsonParser** y **JsonArray**: Para manejar estructuras de respuestas JSON.
- **HTTP Client** y **HTTP Request**: Para crear y realizar solicitudes a la API.
- **HTTP Response**: Enviar la solicitud y obtener la respuesta.
- **Postman**: Para pruebas de la API.

### Dependencias

Asegúrate de tener la siguiente librería en tu proyecto:
- Gson 2.11.0

## Requisitos

- JDK versión 11 o superior.
- IDE (Recomendado: IntelliJ IDEA).
- Configuración de la variable de entorno para la API_KEY.

## CONFIGURACION
1. Clona el repositorio:
  git clone  https://github.com/NoeliaOrsini/ConversorDeMonedas.git

2. Para ejecutar el proyecto:
Abre el proyecto en IntelliJ IDEA.
Asegúrate de que todas las dependencias estén correctamente configuradas.
Ejecuta la clase Main para iniciar el conversor de monedas.

3. ## Configuración de la API

* Obtén una clave de API de [ExchangeRate](https://exchangerate-api.com/). 
* Crea una variable de entorno llamada `API_KEY` (tal como se llama en el código en la clase ConversorAPI) 
y coloca tu clave de API dentro de ella. 
* Esto asegura que tu clave se mantenga segura y no esté expuesta en el código.

4. ## Configura las dependencias:

Asegúrate de tener la librería gson-2.11.0.jar en tu proyecto.
Agrega las dependencias necesarias en tu configuración de proyecto en IntelliJ IDEA.


## Forma de Uso

Una vez que hayas instalado el proyecto y configurado la API_KEY, puedes ejecutar el conversor de monedas. 
El programa presenta un menú al usuario con las siguientes opciones:

### Opciones de Conversión

El menú incluirá las siguientes monedas para convertir:


                ** Escribe el número de la opción deseada de moneda a convertir: **
                1 - Dólar => Pesos argentinos
                2 - Pesos argentinos => Dólar
                3 - Dólar => Real brasileño
                4 - Real brasileño => Dólar
                5 - Dólar => Peso colombiano
                6 - Peso colombiano => Dólar
                7 - Dólar => Peso chileno
                8 - Peso chileno => Dólar
                9 - Dólar => Boliviano
                10 - Boliviano => Dólar
                11 - Salir


### Proceso de Conversión

- El usuario podrá elegir entre las opciones disponibles.
- Podrá realizar múltiples consultas dentro del menú.

- **Un ejemplo de respuesta**:

  Selecciona una opción: 2
  
  Ingresa la cantidad de Pesos argentinos: 500000
  
  500000,00 Pesos argentinos son 510,50 Dólares.
  
  Historial de búsquedas guardado exitosamente.


- Todas las búsquedas realizadas se guardarán en un archivo `historial.json`.

### Ejemplo de historial 
[
{
"monedaOrigen": "ARS",
"cantidad": 500000.0,
"monedaDestino": "USD",
"tasa": "0,001021",
"resultado": "510,5"
}
]

**Realizado por Noelia Orsini para Alura Latam**
