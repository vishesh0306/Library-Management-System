package project.LibraryManagementSystem.entity;

public class Book {
    String bookID;
    String title;
    String author;

    Book(String bookID, String title, String author){
        this.bookID = bookID;
        this.title = title;
        this.author= author;
    }
}
