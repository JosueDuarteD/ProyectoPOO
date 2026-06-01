**Simulador de Cuarto Frío Industrial** 

Este proyecto consiste en una aplicación de escritorio desarrollada en Java que simula el monitoreo, control y persistencia de datos para un sistema de cuartos fríos industriales. El sistema cuenta con una interfaz gráfica interactiva que permite gestionar sensores, simular lecturas críticas y registrar bitácoras en tiempo real.

***Descripción del Problema Abordado***

**Contexto**

  En las industrias alimentaria, farmacéutica y química, el almacenamiento en cuartos fríos (o cámaras frigoríficas) es un eslabón crítico para garantizar la cadena de frío. La alteración involuntaria de las variables físicas en estos entornos puede provocar la pérdida masiva de productos sensibles, sanciones regulatorias y altos costos operativos.

**El Problema**

  El control manual o la falta de un sistema centralizado de simulación y pruebas plantea los siguientes riesgos:
  1. Inestabilidad Térmica y de Presión: Si la temperatura sube o la presión se desestabiliza fuera de los rangos operativos seguros, las mercancías se degradan rápidamente.
  2. Descuidos Operativos (Factor Humano): Dejar la puerta de un cuarto frío abierta destruye la eficiencia térmica, congela los evaporadores y eleva drásticamente el consumo energético.
  3. Falta de Trazabilidad: Sin un registro histórico automatizado (bitácora) y un sistema capaz de guardar y recuperar configuraciones previas, es imposible realizar auditorías o analizar fallos en la cadena de frío.

**La Solución Implementada**

  Para solucionar esto, este software actúa como un **entorno de simulación de pruebas estricto**. Permite a los administradores configurar "cuartos virtuales" definiendo sensores específicos con límites personalizados de tolerancia física. El sistema valida matemáticamente cada lectura simulada y reacciona de forma inmediata ante situaciones de peligro (valores fuera de rango o puertas abiertas) mediante un ecosistema robusto de excepciones y alertas visuales.

<img width="8192" height="4312" alt="ControladorInterfaces-2026-05-29-221058" src="https://github.com/user-attachments/assets/d2e4b709-c7a7-43e5-a3de-411f27841034" />

<img width="908" height="727" alt="CFI-Bienvenida" src="https://github.com/user-attachments/assets/67cef479-2c80-4785-8d4d-abaf9091cd12" />

<img width="908" height="729" alt="CFI-Probar cuarto" src="https://github.com/user-attachments/assets/7bc3c657-b8da-43d0-8cca-7a1bd6230a7c" />

<img width="908" height="727" alt="CFI-Configurar cuarto" src="https://github.com/user-attachments/assets/3a367795-a4e5-4877-990c-dbc596012036" />

<img width="908" height="724" alt="CFI-Cargar textos" src="https://github.com/user-attachments/assets/8bf4972c-5d45-4496-ab72-e52a076655d4" />

<img width="908" height="729" alt="CFI-Cargar sensores" src="https://github.com/user-attachments/assets/557b54d2-0e5c-49e6-b6a4-1235134ed6b2" />

**Instrucciones de Uso**

Una vez iniciado el programa, en la parte superior dispondrás de **4 botones principales** que controlan el intercambio de las pestañas del sistema.

**Pestaña de Configuración (Creación del Cuarto Frío)**

En esta pestaña definirás la topología de tu cuarto frío:
  1. **Agregar Sensores:** Selecciona el tipo de sensor en el menú desplegable, indica la cantidad de dispositivos a implementar mediante el selector numérico y presiona el botón para agregarlos a la lista.
  2. **Edición de Parámetros:** Una vez creados los sensores en la tabla, puedes editar directamente en las celdas sus valores por defecto: **ID, Nombre, Límite Máximo, Límite Mínimo y Valor Actual**.
  3. **Gestión de Archivos:** Puedes modificar los nombres de los archivos destino (tanto de texto ".txt" como de objetos ".bin") o mantener los nombres predeterminados del sistema.
  4. **Remover un Sensor Específico:** Introduce la posición del sensor en la lista (índice de 1 hasta n) y presiona el botón para eliminar dicho dispositivo.
  5. **Vaciar Lista Completa:** Si deseas limpiar toda la configuración, presiona el botón correspondiente. El sistema desplegará un cuadro de diálogo de confirmación para evitar pérdidas accidentales.


**ADVERTENCIA CRÍTICA:** Debes presionar el botón **Guardar Configuración** al terminar tus ediciones. Si cambias de pestaña sin guardar, todos los cambios realizados se perderán.


**Pestañas de Carga (Restauración de Datos)**

Si dispones de datos guardados, puedes hacer uso de los botones de carga dedicados:
- **Carga de Texto / Carga de Objetos:** Al presionarlos, se habilitará una interfaz con un explorador de archivos para buscar y abrir tu archivo ".txt" o ".bin". El sistema emitirá un aviso en pantalla confirmando el éxito de la lectura. Ambos paneles operan bajo la misma lógica de navegación.

**Pestaña de Simulación (Pruebas en Tiempo Real)**

Esta sección permite verificar el comportamiento de la cámara:
1. **Ejecución:** Presiona el botón para iniciar la simulación activa.
2. **Consola de Bitácora:** Abajo del botón se habilitará una casilla de texto que imprimirá un reporte detallado del cuarto frío en tiempo real (indicando la *Hora de inicio del sistema*, la *cantidad de advertencias generadas* y el *tipo de aviso/excepción disparada*).
3. **Guardar Reporte (.txt):** Presiona el botón para guardar el texto. Este proceso exportará tanto el reporte cronológico de fallas como el estado actual de los sensores. **Nota:** Esta operación añade los datos al final del documento, por lo que no perderás el contenido original del archivo de texto.
4. **Guardar Estructura (.bin):** Presiona el botón para guardar la lista de objetos tipo sensor. **Nota:** Esta acción reescribirá por completo el contenido anterior del archivo binario.
