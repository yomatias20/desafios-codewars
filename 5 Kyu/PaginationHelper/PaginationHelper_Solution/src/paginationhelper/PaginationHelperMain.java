
package paginationhelper;

import java.util.Arrays;

public class PaginationHelperMain {

    public static void main(String[] args) {
        PaginationHelper<Integer> helper = new PaginationHelper(Arrays.asList(1,2,4,55,6,20), 4); 
                // try other values and other classes (<String>, <Double>, etc.)
        System.out.println(helper);
        System.out.println("");
        System.out.println("Resolucion:");
        System.out.println("");
        System.out.println("Cantidad total de items: " + helper.itemCount());
        System.out.println("Cantidad total de paginas: " + helper.pageCount());
        System.out.println("");
        System.out.println("Items en cada pagina:");
        for (int i = 0; i < helper.pageCount(); i++) {
            System.out.println("Pagina " + (i + 1) + ": " + helper.pageItemCount(i));
        }
        System.out.println("");
        System.out.println("Pagina en que se encuentra cada item:");
        for (int i = 0; i < helper.itemCount(); i++) {
            helper.collection.get(i);
            System.out.println(helper.collection.get(i) + ": Pagina " + (helper.pageIndex(i) + 1));
        }
        System.out.println("");
    }
    
}
