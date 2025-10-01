// Clase Nodo para el Árbol Binario
class Nodo {
    int valor;         // El dato que guarda el nodo
    Nodo izquierda;    // Hijo izquierdo
    Nodo derecha;      // Hijo derecho

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase Árbol Binario de Búsqueda (BST)
public class arbolBinario {
    Nodo raiz; // Nodo raíz del árbol

    // Método para insertar un valor
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    // Inserción recursiva
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierda = insertarRecursivo(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRecursivo(actual.derecha, valor);
        }
        return actual;
    }

    // Recorrido en InOrden
    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecha);
        }
    }

    // Método principal para probar el árbol
    public static void main(String[] args) {
        arbolBinario arbol = new arbolBinario();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);

        System.out.println("Recorrido InOrden del árbol:");
        arbol.inOrden(arbol.raiz);
    }
}
