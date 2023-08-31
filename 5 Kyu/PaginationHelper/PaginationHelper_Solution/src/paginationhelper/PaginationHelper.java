
package paginationhelper;

import java.util.List;

public class PaginationHelper<I> {

    public List<I> collection;
    public int itemsPerPage;
    
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int itemCount() {
        return collection.size();
    }

    public int pageCount() {
        return (int) Math.ceil((float) collection.size() / itemsPerPage);
    }

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > pageCount() - 1) {
            return -1;
        }
        if (pageIndex == pageCount() -1) {
            return collection.size() % itemsPerPage == 0 ? itemsPerPage : collection.size() % itemsPerPage;
        }
        return itemsPerPage;
    }

    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= collection.size()) {
            return -1;
        }
        return (int) itemIndex / itemsPerPage;
    }

    @Override
    public String toString() {
        return "Datos ingresados: \n" + "Lista: " + collection + "\nItems por pagina: " + itemsPerPage;
    }
    
}
