package ra.bussinessImp;

import custom.utils.InputMethods;
import ra.bussiness.IShop;
import ra.run.BookManagement;

import java.util.List;

public class Book implements IShop {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;

    private Author author;
    private float importPrice, exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
        setExportPrice();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice() {
        this.exportPrice = this.importPrice * IShop.RATE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("------------------Book Input Start------------------");
        System.out.print("Nhập mã sách: ");
        setBookId(InputMethods.getInteger());
        System.out.print("Nhập tên sách: ");
        setBookName(InputMethods.getString());
        System.out.print("Nhập tiêu đề sách: ");
        setTitle(InputMethods.getString());
        System.out.print("Nhập số trang sách: ");
        setNumberOfPages(InputMethods.getInteger());
        System.out.print("Nhập giá bán sách: ");
        setImportPrice(InputMethods.getFloat());
        System.out.print("Nhập số lượng sách: ");
        setQuantity(InputMethods.getInteger());
        System.out.print("Nhập trạng thái: ");
        setBookStatus(InputMethods.getBoolean());

        //Chon tac gia
        List<Author> authorList = BookManagement.authorsList;
        System.out.print("Chọn tác giả phù hợp: \n");
        System.out.println("Danh sách tác giả hiện tại: ");
        int authorListSize = authorList.size();
        if (authorListSize == 0) {
            System.out.println("Danh sách hiện tại đang trống, vui lòng quay lại sau");
        } else {
            for (int i = 0; i < authorListSize; i++) {
                authorList.get(i).displayData();
            }
            while (true) {
                System.out.print("Vui lòng chọn mã tác giả: ");
                int index = InputMethods.getInteger();
                for (int i = 0; i < authorListSize; i++) {
                    Author author = authorList.get(i);
                    if (author.getAuthorId() == index) {
                        System.out.println("Tác giả " + author.getAuthorName() + " đã được chọn");
                        setAuthor(author);
                        break;
                    }
                }
                break;
            }
        }
        System.out.println("------------------Book Input End------------------");
        setExportPrice();
    }

    @Override
    public void displayData() {
        setExportPrice();
        System.out.println("------------------Bpok Info------------------");
        System.out.printf("Mã sách: %-20d ,Tên sách: %-20s ,Tên tác giả: %-20s\n" +
                        "Giá sách: %-20.2f , Số lượng: %-20d\n" +
                        "Trạng thái: %-20s\n",
                getBookId(), getBookName(),
                (getAuthor() == null ? "Không có thông tin tác giả" : getAuthor().getAuthorName()),
                getExportPrice(), getQuantity(),
                (isBookStatus() ? "Còn sách" : "Hết sách")
        );
        System.out.println("-----------------------------------------------");

    }
}
