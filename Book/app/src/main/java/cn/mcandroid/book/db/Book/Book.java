package cn.mcandroid.book.db.Book;

public class Book {
    private  int id;//id
    private String book_name;//书籍名称
    private String author;//作者
    private String ISBN;//ISBN
    private  String date;//出版时间
    private int stock;//库存
    private String msg;//简介

    private  int UPid;//更新id
    private String UPbook_name;//更新书籍名称
    private String UPauthor;//更新作者
    private String UPISBN;//更新ISBN
    private  String UPdate;//更新出版时间
    private int UPstock;//更新库存
    private String UPmsg;//更新简介


    public Book() {
    }

    public Book(String book_name, String author, String ISBN, String date, int stock, String msg) {
        this.book_name = book_name;
        this.author = author;
        this.ISBN = ISBN;
        this.date = date;
        this.stock = stock;
        this.msg = msg;
    }

    public Book(int id, String book_name, String author,
                String ISBN, String date, int stock, String msg) {
        this.id = id;
        this.book_name = book_name;
        this.author = author;
        this.ISBN = ISBN;
        this.date = date;
        this.stock = stock;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUPid() {
        return UPid;
    }

    public void setUPid(int UPid) {
        this.UPid = UPid;
    }

    public String getUPbook_name() {
        return UPbook_name;
    }

    public void setUPbook_name(String UPbook_name) {
        this.UPbook_name = UPbook_name;
    }

    public String getUPauthor() {
        return UPauthor;
    }

    public void setUPauthor(String UPauthor) {
        this.UPauthor = UPauthor;
    }

    public String getUPISBN() {
        return UPISBN;
    }

    public void setUPISBN(String UPISBN) {
        this.UPISBN = UPISBN;
    }

    public String getUPdate() {
        return UPdate;
    }

    public void setUPdate(String UPdate) {
        this.UPdate = UPdate;
    }

    public int getUPstock() {
        return UPstock;
    }

    public void setUPstock(int UPstock) {
        this.UPstock = UPstock;
    }

    public String getUPmsg() {
        return UPmsg;
    }

    public void setUPmsg(String UPmsg) {
        this.UPmsg = UPmsg;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", date='" + date + '\'' +
                ", stock=" + stock +
                ", msg='" + msg + '\'' +
                '}';
    }
}
