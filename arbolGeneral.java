import java.util.ArrayList;
import java.util.List;

// Nodo de un Árbol General
class NodoGeneral {
    String valor;               // El dato que guarda el nodo
    List<NodoGeneral> hijos;    // Lista de hijos

    public NodoGeneral(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    // Agregar hijo
    public void agregarHijo(NodoGeneral hijo) {
        hijos.add(hijo);
    }
}

// Clase Árbol General
public class arbolGeneral {
    NodoGeneral raiz;

    public arbolGeneral(String valorRaiz) {
        raiz = new NodoGeneral(valorRaiz);
    }

    // Recorrido en profundidad (DFS)
    public void recorrer(NodoGeneral nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");
        for (NodoGeneral hijo : nodo.hijos) {
            recorrer(hijo);
        }
    }

    public static void main(String[] args) {
        arbolGeneral arbol = new arbolGeneral("A");

        NodoGeneral b = new NodoGeneral("B");
        NodoGeneral c = new NodoGeneral("C");
        NodoGeneral d = new NodoGeneral("D");

        arbol.raiz.agregarHijo(b);
        arbol.raiz.agregarHijo(c);
        arbol.raiz.agregarHijo(d);

        b.agregarHijo(new NodoGeneral("E"));
        b.agregarHijo(new NodoGeneral("F"));
        c.agregarHijo(new NodoGeneral("G"));

        System.out.println("Recorrido del árbol general:");
        arbol.recorrer(arbol.raiz);
    }
}
