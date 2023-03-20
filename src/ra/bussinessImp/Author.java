package ra.bussinessImp;

import custom.utils.InputMethods;
import ra.bussiness.IShop;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        System.out.println("------------------Author Input Start------------------");
        System.out.print("Nhập mã tác giả: ");
        setAuthorId(InputMethods.getInteger());
        System.out.print("Nhập tên tác giả: ");
        setAuthorName(InputMethods.getString());
        System.out.print("Nhập giới tính: ");
        setSex(InputMethods.getBoolean());
        System.out.print("Nhập năm sinh: ");
        setYear(InputMethods.getInteger());
        System.out.println("------------------Author Input End------------------");
    }

    @Override
    public void displayData() {
        System.out.println("------------------Author Info------------------");
        System.out.printf("Mã tác giả: %-20d ,Tên tác giả: %s\n",
                getAuthorId(), getAuthorName());
        System.out.println("-----------------------------------------------");
    }
}
