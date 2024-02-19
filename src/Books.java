import java.io.Serializable;

public class Books implements Serializable {
    private String author, title;
    private int isbn;
    private double price;

    public Books(){
        isbn = 0;
        title = null;
        author = null;
        price = 0;
    }
    public Books(int isbn, String title, String author, double price){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;

    }
    @Override
    public String toString(){
        return "\nTitle:" + title + "\nAuthor" + author + "\nisbn" + isbn + "\nprice" + price +  "\n";
    }
}
