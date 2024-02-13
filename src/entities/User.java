package entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String password;
    private int age;
    private boolean student;

    public User() {

    }

    public User(String name, String surname, String gender, String password, int age, boolean student) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPassword(password);
        setAge(age);
        setStudent(student);
    }

    public User(int id, String name, String surname, String gender, String password, int age, boolean student) {
        this(name, surname, gender, password, age, student);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender  + '\'' +
                ", age=" + age  + '\'' +
                ", student=" + student  + '\'' +
                '}';
    }
}
