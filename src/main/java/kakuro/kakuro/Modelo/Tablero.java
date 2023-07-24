package kakuro.kakuro.Modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Tablero {

    private cuadro[][] matrizeditables;
    private cuadro[][] matrizsolucion;

    public Tablero() {
        this.matrizeditables = new cuadro[9][8];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                boolean editable = false;
                int numero = 0;

                // Configuración de los cuadros según las filas especificadas
                if (i == 0 && j >= 3 && j <= 4) {
                    editable = true;
                } else if (i == 1 && j >= 2 && j <= 5) {
                    editable = true;
                } else if (i == 2 && j >= 1 && j <= 6) {
                    editable = true;
                } else if (i == 3) {
                    editable = true;
                } else if (i == 4 && (j >= 0 && j <= 2 || j >= 5 && j <= 7)) {
                    editable = true;
                } else if (i == 5 && (j >= 0 && j <= 3 || j >= 5 && j <= 7)) {
                    editable = true;
                } else if (i == 6 && j > 0) {
                    editable = true;
                } else if (i == 7 && (j >= 2 && j <= 5)) {
                    editable = true;
                } else if (i == 8 && j >= 3 && j <= 5) {
                    editable = true;
                }
                if (editable) {
                    matrizeditables[i][j] = new cuadro(true, numero);
                } else {
                    matrizeditables[i][j] = new cuadro(false, -1);
                }

            }
        }
        celdaseditables(0, 0);
    }
    public void mostrarMatriz() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrizeditables[i][j].isEditable()) {
                    System.out.print(matrizeditables[i][j].getNumero()); // Espacio en blanco para cuadro editable
                } else {
                    System.out.print("X"); // 'X' para cuadro no editable
                }
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }

    private boolean celdaseditables(int fila, int columna) {
        // Si hemos llenado todas las casillas, hemos terminado
        if (fila == matrizeditables.length) {
            return true;
        }

        // Si ya hemos llegado al final de la fila, avanzar a la siguiente fila
        if (columna == matrizeditables[0].length) {
            return celdaseditables(fila + 1, 0);
        }

        // Si la casilla no es editable, avanzar a la siguiente casilla
        if (!matrizeditables[fila][columna].isEditable()) {
            return celdaseditables(fila, columna + 1);
        }
        // Casilla editable, intentar poner un número aleatorio del 1 al 9
        Random random = new Random();
        // Casilla editable, intentar poner un número del 1 al 9
        for (int i = 1; i <= 9; i++) {

            int num = random.nextInt(9) + 1; // Generar número aleatorio entre 1 y 9
            if (validarmovimiento(fila, columna, num)) {
                // Poner el número en la casilla y continuar con la siguiente casilla
                matrizeditables[fila][columna].setNumero(num);
                if (celdaseditables(fila, columna + 1)) {
                    return true;
                }
                // Si no se pudo completar el tablero con este número, retroceder (backtrack)
                matrizeditables[fila][columna].setNumero(0);
            }
        }
        // No se pudo encontrar una combinación válida, retroceder (backtrack)
        return false;
    }

    private boolean validarmovimiento(int fila, int columna, int num) {
        // Verificar si el número num se repite en la misma fila o columna
        for (int i = 0; i < matrizeditables.length-1; i++) {
            if (matrizeditables[i][columna].getNumero() == num || matrizeditables[fila][i].getNumero() == num) {
                return false;
            }
        }
        return true;
    }


}
