# Parcial 2 - Árboles

Segundo parcial de Estructuras de Datos, Ingeniería de Sistemas y Computación, Universidad del Quindío. Todo está hecho en Java, con las estructuras (pilas, colas, árboles) implementadas por nosotros y sin usar las colecciones de `java.util`.

## Integrantes

- María José Valencia López
- Juan Esteban Rodríguez Torres
- Nykol Xiomara Ramírez González

## Puntos del parcial

| Punto | Tema | Carpeta |
|---|---|---|
| 1 | Depuración del historial de operaciones (pila) | `src/punto1` |
| 2 | Obtener un segmento del historial (pila) | `src/Punto2` |
| 3 | Selección de solicitudes para una jornada (cola) | `src/punto3` |
| 4 | Árbol binario de búsqueda: consulta de equipos por rango | `src/Punto4` |
| 5 | Árboles ABB y AVL: recorridos, inserción, rotaciones y eliminación | `src/punto5` |

Cada punto es un paquete de Java independiente, con sus propias clases de apoyo (`Node` o `Nodo`, `Stack`, `Queue`, etc.).

## Estructura

```
Parcial-2/
├── README.md
└── src/
    ├── punto1/
    ├── Punto2/
    ├── punto3/
    ├── Punto4/
    └── punto5/
```

## Cómo compilar y ejecutar

Desde la raíz del proyecto:

```bash
javac -d bin src/*/*.java
```

Para ejecutar un punto, se indica el paquete y la clase `Main`:

```bash
java -cp bin punto1.Main
java -cp bin punto3.Main
java -cp bin Punto4.Main
```

El punto 2 no tiene `Main`: se usa desde la clase `Obtener`.

## Documento de desarrollo

El análisis de cada punto, con ejemplos y capturas, está en el documento "Desarrollo Parcial 2 - Árboles".
