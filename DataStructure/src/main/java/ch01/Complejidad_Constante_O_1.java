package ch01;

public class Complejidad_Constante_O_1 {

    /**
     * Algoritmo con Complejidad constante Big O(1)
     * max -> dados dos valores entereos retorna el maximo de ambos,
     * La funcion max() tardara siempre los mismo no depende de los datos de entrada
     */
    private int max(int a, int b){
        if (a >= b)
            return a;
        return b;
    }
}
