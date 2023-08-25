
package maximumsubarraysum;

import java.util.Arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {2, 5, -7, 8, -4, -6}; // try other values
        int suma = sequence(arr);
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("");
        System.out.println("Result: " + suma);
        System.out.println("");
    }
    
    public static int sequence(int[] arr) {
        int[] sumaMax = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int [] sumaLinea = new int[arr.length - i];
            sumaLinea[0] = arr[i];
            for (int j = 1; j < arr.length - i; j++) {
                sumaLinea[j] = sumaLinea[j - 1] + arr[i + j];
            }
            Arrays.sort(sumaLinea);
            sumaMax[i] = sumaLinea[sumaLinea.length - 1];
        }
        Arrays.sort(sumaMax);
        if (sumaMax.length > 0) {
            return Math.max(sumaMax[sumaMax.length - 1], 0);
        } else {
            return 0;
        }
    }
    
}
