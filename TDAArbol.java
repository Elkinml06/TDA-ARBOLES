import java.util.ArrayList;
import java.util.List;

public class TDAArbol {

    // ===================== TIPOS DE NODOS =====================
    static class Nodo {
        String valor;            // Contenido del nodo
        List<Nodo> hijos;        // Hijos del nodo (puede tener N hijos)

        Nodo(String valor) {
            this.valor = valor;
            this.hijos = new ArrayList<>();
        }

        // Agregar hijo al nodo
        void agregarHijo(Nodo hijo) {
            hijos.add(hijo);
        }
    }

    // ===================== NIVELES Y ALTURA =====================
    static int altura(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.hijos.isEmpty()) return 1;
        int maxAltura = 0;
        for (Nodo hijo : nodo.hijos) {
            maxAltura = Math.max(maxAltura, altura(hijo));
        }
        return maxAltura + 1;
    }

    // ===================== PESO =====================
    static int peso(Nodo nodo) {
        if (nodo == null) return 0;
        int total = 1; // cuenta el nodo actual
        for (Nodo hijo : nodo.hijos) {
            total += peso(hijo);
        }
        return total;
    }

    // ===================== ORDEN =====================
    // El orden se define al crear la estructura (máx. hijos permitidos)
    static int orden = 3; // ejemplo: orden = 3 → cada nodo puede tener hasta 3 hijos

    // ===================== GRADO =====================
    static int grado(Nodo nodo) {
        if (nodo == null) return 0;
        int maxGrado = nodo.hijos.size();
        for (Nodo hijo : nodo.hijos) {
            maxGrado = Math.max(maxGrado, grado(hijo));
        }
        return maxGrado;
    }

    // ===================== SUB-ÁRBOL =====================
    // Imprime un subárbol desde el nodo indicado
    static void mostrarSubArbol(Nodo nodo) {
        mostrarArbol(nodo, "");
    }

    // ===================== RECORRIDO (para mostrar ramas e hijos) =====================
    static void mostrarArbol(Nodo nodo, String espacio) {
        if (nodo == null) return;
        System.out.println(espacio + "- " + nodo.valor);
        for (Nodo hijo : nodo.hijos) {
            mostrarArbol(hijo, espacio + "  ");
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {
        // INTRODUCCIÓN: Creamos un árbol de ejemplo
        Nodo raiz = new Nodo("A (Raíz)");

        // TIPOS DE NODOS: Padres, hijos, hojas
        Nodo b = new Nodo("B (Hijo de A)");
        Nodo c = new Nodo("C (Hijo de A)");
        Nodo d = new Nodo("D (Hijo de A)");
        raiz.agregarHijo(b);
        raiz.agregarHijo(c);
        raiz.agregarHijo(d);

        Nodo e = new Nodo("E (Hijo de B)");
        Nodo f = new Nodo("F (Hijo de B)");
        b.agregarHijo(e);
        b.agregarHijo(f);

        Nodo g = new Nodo("G (Hijo de C)");
        c.agregarHijo(g);

        // Mostrar todo el árbol
        System.out.println("=== ÁRBOL COMPLETO ===");
        mostrarArbol(raiz, "");

        // Niveles y Altura
        System.out.println("\nAltura del árbol: " + altura(raiz));

        // Peso
        System.out.println("Peso del árbol (número total de nodos): " + peso(raiz));

        // Orden
        System.out.println("Orden definido del árbol: " + orden);

        // Grado
        System.out.println("Grado del árbol (máx. hijos en un nodo): " + grado(raiz));

        // Sub-Árbol
        System.out.println("\n=== SUB-ÁRBOL desde nodo B ===");
        mostrarSubArbol(b);
    }
}
