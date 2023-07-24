package kakuro.kakuro.Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cuadro {
    private boolean editable;
    private int numero;

    public cuadro(boolean editable, Integer numero) {
        this.editable = editable;
        this.numero = numero;
    }
}
