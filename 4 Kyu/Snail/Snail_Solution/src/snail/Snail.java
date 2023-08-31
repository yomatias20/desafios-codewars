package snail;

import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        int dim = 4; // try other values
        int[][] matrix = new int[dim][dim];
        int contador = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                contador++;
                matrix[i][j] = contador;
            }
        }
        System.out.println("Matriz original: ");
        for (int i = 0; i < dim; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("");
        int[] result = snail(matrix);
        System.out.println("Nuevo array: " + Arrays.toString(result));
        System.out.println("");
    }

    public static int[] snail(int[][] matrix) {
        int dim = matrix.length;
        if (dim == 0) {
            return new int[0];
        }
        if (matrix[0].length == 0) {
            return new int[0];
        }
        int[] snailArray = new int[dim * dim];
        int contadorGeneral = 0;
        int contadorColumna = 0;
        int contadorFila = 0;
        int contadorVueltas = 0;
        snailArray[0] = matrix[0][0];
        for (int h = dim - 1; h > 0; h--) {
            for (int i = 0; i < (h == dim -1 ? 3 : 2); i++) {
                if (contadorVueltas > 0 && contadorVueltas % 4 == 0) {
                    contadorFila++;
                }
                for (int j = 0; j < h; j++) {
                    contadorGeneral++;
                    contadorColumna++;
                    snailArray[contadorGeneral] = matrix[contadorFila][contadorColumna];
                }
                matrix = rotateMatrix(matrix);
                contadorVueltas++;
                contadorColumna = (int) (contadorVueltas - 1) / 4;
            }
        }
        return snailArray;
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int dim = matrix.length;
        int[][] matrixR = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrixR[i][j] = matrix[j][dim - i - 1];
            }
        }
        return matrixR;
    }

}
