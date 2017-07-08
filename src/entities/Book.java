package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankur on 7/7/17.
 */
@Entity
public class Book {
    //Question 14

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String bookName;

    //Question 16 one to many bidirectional
/*
    @ManyToOne
    Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
*/

    //Question 17 many to many
    @ManyToMany(mappedBy = "books")
    List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

}
