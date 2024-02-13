package repositories;

import data.interfaces.IDB;
import entities.Book;
import repositories.interfaces.IBookRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private final IDB db;  // Dependency Injection

    public BookRepository(IDB db) {
        this.db = db;
    }

    public boolean createBook(Book book) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO books(title,author,genre,type_of_book,language,age_limit,additional_info) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getGenre());
            st.setString(4, book.getType_of_book());
            st.setString(5, book.getLanguage());
            st.setInt(6, book.getAge_limit());
            st.setString(7, book.getAdditional_info());


            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return false;
    }

    public Book getBook(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT book_id,title,author,genre,type_of_book,language,age_limit,additional_info FROM books WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("type_of_book"),
                        rs.getString("language"),
                        rs.getInt("age_limit"),
                        rs.getString("additional_info"));


            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    public List<Book> getAllBooks() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT book_id,title,author,genre,type_of_book,language,age_limit,additional_info FROM books";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("type_of_book"),
                        rs.getString("language"),
                        rs.getInt("age_limit"),
                        rs.getString("additional_info"));

                books.add(book);
            }

            return books;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }
}
