package Service;

import java.util.HashMap;

import Repository.Database;
import project.LibraryManagementSystem.entity.Book;

public class LibraryService {
    public void addBook(Book b, int q){
        for(Book book : Database.books.keySet()) {
            if(book.bookID.equals(b.bookID)) {
                Database.books.put(book, Database.books.get(book)+q);
                return;
            }
        }
        Database.books.put(b, q);
    }

    public boolean isAvailable(String bookID) {
        for(Book book : Database.books.keySet()) {
            if(book.bookID.equals(bookID)) {
                return true;
            }
        }
        return false;
    }

    public void updateQuantity(String bookID, Integer q) {
        for(Book book : Database.books.keySet()) {
            if(book.bookID.equals(bookID)) {
                Database.books.put(book, Database.books.get(book) + q);
                return;
            }
        }
        System.out.println("Book not available");
    }

}
