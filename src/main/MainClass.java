package main;

import entities.Address;
import entities.Author;
import entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.HibernateUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankur on 7/7/17.
 */
public class MainClass {
    static int i = 0;
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Author author = new Author();
        author.setFirstName("Ankur");
        author.setLastName("Upadhyay");
        author.setAge(21);

        //Question 2.
        //create operation
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        //read operation
        session.beginTransaction();
        Author author1=session.get(Author.class,1);
        session.getTransaction().commit();
        System.out.println("=====================================");
        System.out.println(author1);

        //update operation
        session.beginTransaction();
        Author author2=session.get(Author.class,1);
        author2.setFirstName("Tanuj");
        session.update(author2);
        session.getTransaction().commit();
        System.out.println("=====================================");
        System.out.println(author2);

        //delete operation
        session.beginTransaction();
        Author author3=session.get(Author.class,1);
        session.delete(author3);
        session.getTransaction().commit();
        System.out.println("=====================================");
        System.out.println(author3);

        //Question 13
        List<String> subject = new ArrayList<>();
        subject.add("JAVA");
        subject.add("C++");
        subject.add("PHP");

        //Question 4
        Author author5 = new Author();
        author5.setFirstName("Ankur");
        author5.setLastName("Upadhyay");
        author5.setAge(21);
        String dob = "1996-03-03";
        Date date = Date.valueOf(dob);
        author5.setDateOfBirth(date);
        author5.setSubjects(subject);
        mainClass.save(author5);

        Author author6 = new Author();
        author6.setFirstName("Tanuj");
        author6.setLastName("Kapila");
        author6.setAge(20);
        String dob6 = "1996-05-13";
        Date date6 = Date.valueOf(dob6);
        author6.setDateOfBirth(date6);
        author6.setSubjects(subject);
        mainClass.save(author6);

        Author author7 = new Author();
        author7.setFirstName("Shubham");
        author7.setLastName("Rawat");
        author7.setAge(23);
        String dob7 = "1995-08-12";
        Date date7 = Date.valueOf(dob7);
        author7.setDateOfBirth(date7);
        author7.setSubjects(subject);

        Author author8 = new Author();
        author8.setFirstName("Yashi");
        author8.setLastName("Gupta");
        author8.setAge(21);
        String dob8 = "1992-12-29";
        Date date8 = Date.valueOf(dob8);
        author8.setDateOfBirth(date8);
        author8.setSubjects(subject);
        mainClass.save(author8);

        //Question 11
        Address address=new Address();
        address.setStreetNumber(10);
        address.setLocation("Ghaziabad");
        address.setState("U.P.");
        author8.setAddress(address);
        mainClass.save(author8);


        //Question 5.
        sessionFactory.close();

        //Question 15.
        /*Book book = new Book();
        book.setBookName("HeadFirst Java");
        author7.setBook(book);
        SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory1.openSession();
        session1.beginTransaction();
        session1.save(author7);
        session1.save(book);
        session1.getTransaction().commit();
        session1.close();*/

        //Question 16. one to many unidirectional
/*
        Book book = new Book();
        book.setBookName("Rich Dad Poor Dad");
        Book book1 = new Book();
        book1.setBookName("The Complete Reference Java");
        Book book2 = new Book();
        book2.setBookName("My Own Book");
        author7.getBooks().add(book);
        author7.getBooks().add(book1);
        author7.getBooks().add(book2);
        SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory1.openSession();
        session1.beginTransaction();
        session1.save(author7);
        session1.save(book);
        session1.save(book1);
        session1.save(book2);
        session1.getTransaction().commit();
        session1.close();
*/
        //Question 16 one to many bidirectional
/*        Book book = new Book();
        book.setBookName("Rich Dad Poor Dad");
        book.setAuthor(author7);
        Book book1 = new Book();
        book1.setBookName("The Complete Reference Java");
        book1.setAuthor(author7);
        Book book2 = new Book();
        book2.setBookName("My Own Book");
        book2.setAuthor(author7);
        author7.getBooks().add(book);
        author7.getBooks().add(book1);
        author7.getBooks().add(book2);
        SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory1.openSession();
        session1.beginTransaction();
        session1.save(author7);
        session1.save(book);
        session1.save(book1);
        session1.save(book2);
        session1.getTransaction().commit();
        session1.close();*/

        //Question 17
        Book book = new Book();
        book.setBookName("Rich Dad Poor Dad");
        Book book1 = new Book();
        book1.setBookName("The Complete Reference Java");
        Book book2 = new Book();
        book2.setBookName("My Own Book");
        author5.getBooks().add(book);
        author5.getBooks().add(book1);
        author5.getBooks().add(book2);
        book.getAuthorList().add(author6);
        book1.getAuthorList().add(author5);
        book2.getAuthorList().add(author5);

        SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory1.openSession();
        session1.beginTransaction();
        session1.save(author7);
        session1.save(book);
        session1.save(book1);
        session1.save(book2);
        session1.getTransaction().commit();
        session1.close();
    }
    public Integer save(Author e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + e.toString());
        return e.getUserId();
    }
}
