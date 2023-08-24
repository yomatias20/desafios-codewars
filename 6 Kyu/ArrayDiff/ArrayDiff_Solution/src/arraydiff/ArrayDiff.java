
package arraydiff;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayDiff {

    public static void main(String[] args) {
        int[] arrA = {5, 6, 2, 4, 9}; // try other values
        int[] arrB = {2, 6}; // try other values
        int[] result = arrayDiff(arrA, arrB);
        System.out.println(Arrays.toString(result));
    }
    
    public static int[] arrayDiff(int[] a, int[] b) {
        int[] c = Arrays.copyOf(a, a.length);
        IntStream cStream = IntStream.of(c);
        for (int i = 0; i < b.length; i++) {
            final int desc = b[i];
            cStream = cStream.filter(n -> n != desc);
        }
        return cStream.toArray();
    }

}
