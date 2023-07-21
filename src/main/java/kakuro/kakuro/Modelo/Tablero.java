package kakuro.kakuro.Modelo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tablero {

    private cuadro[][] matriz;

    public Tablero() {
        this.matriz = new cuadro[9][8]; // Corregimos el tamaño de la matriz

        for (int i = 0; i < 9; i++) { // Corregimos el límite del bucle
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
                matriz[i][j] = new cuadro(true, editable, numero);
            }
        }
    }
    public void mostrarMatriz() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j].isEditable()) {
                    System.out.print("  "); // Espacio en blanco para cuadro editable
                } else {
                    System.out.print("X "); // 'X' para cuadro no editable
                }
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }


}
