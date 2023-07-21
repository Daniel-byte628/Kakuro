package kakuro.kakuro.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cuadro {
    private boolean vacio;
    private boolean editable;
    private int numero;

    public cuadro(boolean vacio, boolean editable, int numero) {
        this.vacio = vacio;
        this.editable = editable;
        this.numero = numero;
    }
}
