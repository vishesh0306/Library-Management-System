package Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Repository.Database;
import project.LibraryManagementSystem.entity.*;

public class UserService {

    public String viewAvailableBooks() {
        StringBuilder sb = new StringBuilder();
        boolean anyAvailable = false;
    
        for (Map.Entry<Book, Integer> entry : Database.books.entrySet()) {
            if (entry.getValue() > 0) {
                Book book = entry.getKey();
                sb.append("ID: ").append(book.bookID)
                  .append(", Title: ").append(book.title)
                  .append(", Author: ").append(book.author)
                  .append(", Copies: ").append(entry.getValue())
                  .append("\n");
                anyAvailable = true;
            }
        }
    
        if (!anyAvailable) {
            return "No books are currently available.";
        }
    
        return sb.toString();
    }


    LibraryService libraryService = new LibraryService();

    public void getBook(String bookId) {
        for (Book book : Database.books.keySet()) {
            if (book.bookID.equals(bookId)) {
                int count = Database.books.get(book);
                if (count > 0) {
                    libraryService.updateQuantity(bookId, -1); // decrease quantity
                   System.out.println("Book is available");
                } else {
                    System.out.println("Book is not available");
                }
            }
        }
      
    }

    public void returnBook(String bookId) {
        libraryService.updateQuantity(bookId, 1); 
        System.out.println("Book is returned");
    }
}
