package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String title;
    private String author;
    private int quantity;
    private double price;



    @Override
    public String toString() {
        return id + ": " + title + " " + author + " - " + quantity+" "+price;
    }
}

