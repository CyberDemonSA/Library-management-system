package entities;

public class Order {
    public int id;
    public int users_id;
    public int book_id;
    public String date_of_issue;
    public String due_date;

    public Order(){

    }

    public Order(int users_id, int book_id, String date_of_issue, String due_date){
        setUsers_id(users_id);
        setBook_id(book_id);
        setDate_of_issue(date_of_issue);
        setDue_date(due_date);
    }

    public Order(int id, int users_id, int book_id, String date_of_issue, String due_date){
        this(users_id, book_id, date_of_issue, due_date);
        setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getDate_of_issue() {
        return date_of_issue;
    }

    public String getDue_date() {
        return due_date;
    }

    public String toString() {
        return "order{" +
                "id=" + id +
                ", user id='" + users_id + '\'' +
                ", book id='" + book_id + '\'' +
                ", date of issue=" + date_of_issue + '\'' +
                ", due date=" + due_date + '\'' +
                '}';
    }
}
