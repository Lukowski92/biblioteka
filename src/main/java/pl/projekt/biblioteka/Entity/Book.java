package pl.projekt.biblioteka.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Książki")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "ISBN")
  private String isbn;

  @Column(name = "Tytuł")
  private String title;

  @Column(name = "Autor")
  private String author;

  @Column(name = "Dostępność")
  private int numberOfBooks;

  public Long getId() {
    return id;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getNumberOfBooks() {
    return numberOfBooks;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setNumberOfBooks(int numberOfBooks) {
    this.numberOfBooks = numberOfBooks;
  }
}
