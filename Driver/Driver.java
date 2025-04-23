import java.util.Scanner;
<<<<<<< HEAD
import Service.UserService;
=======

import Service.LibraryService;
import Service.UserService;
import project.LibraryManagementSystem.entity.Book;

>>>>>>> 072f0ed01f47b262eb2182cdb8045249730b1307
public class Driver {
    public static void main(String[] args) {
        System.out.println(
                "********************************** WELCOME TO THE LIBRARY ***********************************");
        System.out.println(
                "---------------------------------- Login as User or Librarian ? ----------------------------------------");
        System.out.println("****************************  1:User   2:Librarian ******************************");
        System.out.println("---------------------------  Enter your choice ---------------------------------");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                UserService u = new UserService();
                System.out.println("************************** What you want to perform ***************************");
                System.out.println(
                        "-----------  1:Show All Books ------------   2:Get The Book -----------------   3:Return The Book");
                System.out.println("-----------------  Enter your choice -----------------------");
                int choice2 = sc.nextInt();
                switch (choice2) {
                    case 1:
                        u.viewAvailableBooks();
                        break;
                    case 2:
                        System.out.println(
                                "-------------------------------- Enter ID of the book ---------------------------------");
                        String idBook = sc.next();
                        u.getBook(idBook);
                        break;
                    case 3:
                        System.out.println(
                                "-------------------------------- Enter Id of the book ----------------------------------");
                        String idBook1 = sc.next();
                        u.returnBook(idBook1);
                        System.out
                                .println("<----------------------------  Book is returned  ------------------------>");
                    default:
                        System.out.println("Enter correct choice");
                        break;
                }
                break;
            case 2:
                LibraryService l = new LibraryService();
                System.out.println("-------------------------- What you want to perform -----------------------------");
                System.out.println(
                        "-------------------------------- 1:Add The Book -----------  2:Is Book Availaible? ---------------  3:update The Quantity");
                System.out
                        .println("------------------------- Enter your choice --------------------------------------");
                int choice3 = sc.nextInt();
                switch (choice3) {
                    case 1:
                        System.out.println("------------------------- Enter the book name --------------------------");
                        String name = sc.nextLine();
                        System.out.println(
                                "------------------------- Enter ID of the book ---------------------------------");
                        String id = sc.next();
                        System.out.println(
                                "-------------------------- Enter the author name --------------------------------");
                        String author = sc.nextLine();
                        System.out.println(
                                "--------------------------- Enter the quantity of book -----------------------------");
                        int quant = sc.nextInt();
                        Book b = new Book(id, name, author);
                        l.addBook(b, quant);
                        System.out.println("Book is Added");
                        break;
                    case 2:
                        System.out.println("---------------------  Enter ID of the book  -----------------------");
                        String str = sc.next();
<<<<<<< HEAD
                        if (l.isAvailaible(str)) {
                            System.out.println("-----------------  Hey User!...Book is availaible  --------------------");
=======
                        if (l.isAvailable(str)) {
                            System.out
                                    .println("-----------------  Hey User!...Book is availaible  --------------------");
>>>>>>> 072f0ed01f47b262eb2182cdb8045249730b1307
                        } else {
                            System.out.println( "-----------------  Sorry...The book is not currently availaible  -----------------------");
                        }
                        break;
                    case 3:
                        System.out.println("Enter ID of the book");
                        String str1 = sc.next();
                        System.out.println("-------------------  Enter quantity  -----------------------");
                        int qua = sc.nextInt();
                        l.updateQuantity(str1, qua);
                        System.out.println("---------------------  QUANTITY UPDATED  -----------------------");
                        break;
                    default:
                        System.out.println("---------------------  Enter correct choice  ----------------------");
                        break;
                }
                break;
            default:
                System.out.println("---------------------------  Enter correct choice  -------------------------");
                break;
        }
    }
}