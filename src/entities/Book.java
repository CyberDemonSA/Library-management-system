package entities;

public class Book {
    public int id;
    public String title;
    public String author;
    public String genre;
    public String type_of_book;
    public String language;
    public int age_limit;
    public String additional_info;

    public Book(){

    }

    public Book(String title, String author, String genre, String type_of_book, String language, int age_limit, String additional_info){
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setType_of_book(type_of_book);
        setLanguage(language);
        setAge_limit(age_limit);
        setAdditional_info(additional_info);
    }

    public Book(int id, String title, String author, String genre, String type_of_book, String language, int age_limit, String additional_info){
        this(title, author, genre, type_of_book, language, age_limit, additional_info);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getType_of_book() {
        return type_of_book;
    }

    public String getLanguage() {
        return language;
    }

    public int getAge_limit() {
        return age_limit;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setType_of_book(String type_of_book) {
        this.type_of_book = type_of_book;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAge_limit(int age_limit) {
        this.age_limit = age_limit;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre + '\'' +
                ", type of book=" + type_of_book + '\'' +
                ", language=" + language + '\'' +
                ", age limit=" + age_limit + '\'' +
                ", additional info=" + additional_info + '\'' +
                '}';
    }
}
