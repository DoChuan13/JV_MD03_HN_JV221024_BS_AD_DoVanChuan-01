package ra.bussinessImp;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return (int) (book1.getExportPrice() - book2.getExportPrice());
    }
}
