package prodfib;

import java.util.Arrays;

public class ProdFib {

    public static void main(String[] args) {
        long prod = 104; // try other values
        long[] result = productFib(prod);
        System.out.println("Product: " + prod);
        System.out.println("");
        System.out.println("Result: "+ Arrays.toString(result));
        System.out.println("");
    }

    public static long[] productFib(long prod) {
        long aux;
        long[] result = new long[3];
        result[0] = 0;
        result[1] = 1;
        result[2] = 0;
        while (result[0] * result[1] <= prod) {
            if (result[0] * result[1] == prod) {
                result[2] = 1;
                return result;
            }
            aux = result[0] + result[1];
            result[0] = result[1];
            result[1] = aux;
        }
        return result;
    }

}
