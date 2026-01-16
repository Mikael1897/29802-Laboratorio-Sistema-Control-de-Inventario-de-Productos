# Paquete: Controlador
**Responsable:** Jaime Hidalgo.

Esta carpeta es el cerebro que une al Modelo con la Vista.

## Archivos que van aquí:
1. `Controlador.java`: 
   - Contiene el método `public static void main(String[] args)`.
   - Inicia el programa.
   - Tiene el bucle principal (`while`) y el `switch` para navegar las opciones.
   - Llama a `vista.mostrarMenu()` y luego a `modelo.agregar()`, etc.