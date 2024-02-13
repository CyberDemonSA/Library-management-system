package repositories.interfaces;

import entities.Book;

import java.util.List;

public interface IBookRepository {
    boolean createBook(Book book);
    Book getBook(int id);
    public List<Book> getAllBooks();
}