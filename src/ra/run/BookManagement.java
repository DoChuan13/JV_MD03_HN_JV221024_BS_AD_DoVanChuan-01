package ra.run;

import custom.utils.InputMethods;
import ra.bussinessImp.Author;
import ra.bussinessImp.Book;
import ra.bussinessImp.BookComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookManagement {
    public static List<Author> authorsList = new ArrayList<>();
    public static List<Book> booksList = new ArrayList<>();

    public static void main(String[] args) {
//        authorsList.add(new Author(1, "Minh Thu", false, 2000));
//        authorsList.add(new Author(2, "Do Chuan", true, 1992));
//        authorsList.add(new Author(3, "Hai Yen", false, 1992));
//        authorsList.add(new Author(4, "Duc Vuong", true, 1993));
//        booksList.add(new Book(1, "Book 1", "Book 1", 200, authorsList.get(2), 200, 80, false));
//        booksList.add(new Book(2, "Book 2", "Book 2", 2000, authorsList.get(0), 300, 20, true));
//        booksList.add(new Book(3, "Book 3", "Book 3", 200, authorsList.get(1), 100, 70, false));
//        booksList.add(new Book(4, "Book 4", "Book 4", 200, authorsList.get(1), 200, 80, true));
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả\n" +
                    "2. Nhập số sách và nhập thông tin các sách\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách\n" +
                    "5. Thoát");

            System.out.print("Nhập lựa chọn phù hợp: ");
            byte option = InputMethods.getByte();
            switch (option) {
                case 1:
                    inputAuthorInfo();
                    break;
                case 2:
                    inputBookInfo();
                    break;
                case 3:
                    sortBookByExportPrice();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng thử lại...");
            }
//            System.out.print("Nhấn phím bất kỳ để tiếp tục.");
            InputMethods.pressAnyKey();
        }
    }

    private static void inputAuthorInfo() {
        Author author = new Author();
        author.inputData();
        authorsList.add(author);
        System.out.println("-----Thông tin tác giả được nhập thành công-----");
    }

    private static void inputBookInfo() {
        Book book = new Book();
        book.inputData();
        booksList.add(book);
        System.out.println("-----Thông tin sách được nhập thành công-----");
    }

    private static void sortBookByExportPrice() {
        if (booksList.size() == 0) {
            System.out.println("Danh sách sách đang trống");
            return;
        }
        BookComparator bookComparator = new BookComparator();
        Collections.sort(booksList, bookComparator);
        displayBooksList();
    }

    private static void displayBooksList() {
        int bookListSize = booksList.size();
        for (int i = 0; i < bookListSize; i++) {
            booksList.get(i).displayData();
        }
    }

    private static void findBookByAuthor() {
        System.out.print("Nhập tên tác giả cần tìm kiếm: ");
        String author = InputMethods.getString();
        int bookListSize = booksList.size();
        boolean flag = false;
        for (int i = 0; i < bookListSize; i++) {
            Book book = booksList.get(i);
            if (book.getAuthor()==null){
                System.err.println("Sách không có thông tin tác giả");
                return;
            }
            if (book.getAuthor().getAuthorName().equals(author)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.err.println("\nKhông tìm thấy kết quả hợp lệ...\n");
            return;
        }
        System.out.println("Các sách của tác giả " + author + " là: ");
        for (int i = 0; i < bookListSize; i++) {
            Book book = booksList.get(i);
            if (book.getAuthor().getAuthorName().equals(author)) {
                book.displayData();
            }
        }
    }
}
