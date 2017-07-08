package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

	//Question 1.
/*
	@Id
	@Column
	private Integer userId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Integer age;

	//Question 3
	@Column
	private Date dateOfBirth;

*/
	//Question 6.
/*
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name =("User_Id"))
	private Integer userId;

	@Column(name =("First_Name"))
	private String firstName;

	@Column(name =("Last_Name"))
	private String lastName;

	@Column(name =("Age"))
	private Integer age;

	@Column(name =("Date_Of_Birth"))
	private Date dateOfBirth;
*/

	@Id
	//Question 9
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =("User_Id"))
	private Integer userId;

	@Column(name =("First_Name"))
	private String firstName;

	//Question 7
	@Transient
	private String lastName;

	@Column(name =("Age"))
	private Integer age;

	//Question 8
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//Question 11.
	@Embedded
	Address address;

	//Question 12.
	@ElementCollection
	List<String> subjects = new ArrayList<>();

	//Question 15.
	//@OneToOne
	//@JoinColumn(name = "Book_join_column")
	//Book book;

	//Question 16 one to many(unidirectional)
	/*@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name="Author_id")
				,inverseJoinColumns = @JoinColumn(name = "Book_id"))

	*/
	//Question 16 one to many without additional table
	/*@OneToMany(mappedBy = "author")
	Collection<Book> books = new HashSet<>();
*/
	//Question 17 many to many
	@ManyToMany
	List<Book> books = new ArrayList<>();
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

/*
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
*/

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
/*	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() { return age; }

	public void setAge(Integer age) { this.age = age;}

	public Date getDateOfBirth() { return dateOfBirth; }

	public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

	public List<String> getSubjects() { return subjects; }

	public void setSubjects(List<String> subjects) { this.subjects = subjects; }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age+ ", dateOfBirth="+ dateOfBirth +"]";
	}

}