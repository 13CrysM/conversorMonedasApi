README - Sistema de Conversión de Divisas 💰
📌 Descripción
Este proyecto es un conversor de divisas desarrollado en Java que permite obtener tasas de cambio en tiempo real y realizar conversiones entre diferentes monedas. El sistema se conecta a la API de ExchangeRate-API para obtener los datos más actualizados.

🌟 Características Principales
✅ Conversión en tiempo real entre múltiples divisas

✅ Soporte para 12 monedas diferentes (USD, EUR, GBP, CHF, JPY, HKD, CAD, CNY, AUD, BRL, RUB, MXN)

✅ Interfaz de usuario intuitiva por consola

✅ Validación de entradas del usuario

✅ Manejo de errores en conexiones API

🛠️ Tecnologías Utilizadas
Java 17+

HTTP Client de Java (para conexiones API)

Gson (para parseo de JSON)

ExchangeRate-API (fuente de datos)

📥 Instalación y Ejecución
Requisitos previos:

JDK 17 o superior instalado

Conexión a Internet (para acceder a la API)

Pasos para ejecutar:

bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/conversor-divisas.git

# Navegar al directorio del proyecto
cd conversor-divisas

# Compilar (opcional, si no usas un IDE)
javac -cp .:gson-2.8.9.jar Principal.java

# Ejecutar
java -cp .:gson-2.8.9.jar Principal
🖥️ Uso del Programa
Al iniciar el programa, verás un mensaje de bienvenida.

Ingresa el código de la divisa de origen (ej. "USD", "EUR", "MXN").

Selecciona la divisa destino del menú mostrado (1-12).

Ingresa la cantidad a convertir.

El programa mostrará el resultado de la conversión.

Puedes realizar múltiples conversiones o salir con la opción 0.

📷 Capturas de Pantalla
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*- Bienvenido al sistema de conversión de divisas -*

Ingresa el código de la divisa ORIGEN (ejemplo: USD, EUR, MXN) o escribe '0' para salir del sistema:
MXN

1.- Dólares Americanos (USD)
2.- Euros (EUR)
...
12.- Pesos Mexicanos (MXN)
0.- Salir

Selecciona una opción válida (1-12):
1
Ingresa la cantidad a convertir:
100
La cantidad de: 100.00 MXN equivalen a: 5.92 USD
📊 Estructura del Proyecto
src/
├── Principal.java            # Punto de entrada del programa
├── ConsultaMoneda.java       # Maneja las consultas a la API
├── ConversorDivisa.java      # Lógica de conversión de divisas
├── Moneda.java               # Modelo para datos de par de divisas
└── TasasMoneda.java          # Modelo para tasas de cambio
🤝 Contribuciones
Las contribuciones son bienvenidas. Por favor abre un issue o pull request con tus sugerencias.

📜 Licencia
Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

Desarrollado con ❤️ por [Tu Nombre] | [2023]
