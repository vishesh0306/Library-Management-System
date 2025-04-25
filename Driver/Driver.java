package project.LibraryManagementSystem.Driver;
import project.LibraryManagementSystem.Service.*;
import project.LibraryManagementSystem.entity.*;
import project.LibraryManagementSystem.Repository.*;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE LIBRARY");
        boolean flag = true;
        while(flag) {
        	System.out.println("1:User Sign Up, 2:User Login, 3:Librarian Login");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
            	case 1: 
            		System.out.print("Enter name of user: ");
            		sc.nextLine();
            		String name = sc.nextLine();
            		System.out.print("Enter username/ID: ");
            		String id = sc.next();
            		System.out.print("Set password: ");
            		String pass1 = sc.next();
            		System.out.print("Confirm password: ");
            		String pass2 = sc.next();
            		
            		if(pass1.equals(pass2)) {
            			UserService.addUser(name, id, pass1);
            		} else {
            			System.out.println("password did not match");
            		}
            		String[] temp = {""};
                	main(temp);
            		break;
            		
                case 2:
                	System.out.print("Enter your username/ID: ");
            		String userID = sc.next();
            		System.out.print("Enter your password: ");
            		String pass = sc.next();
            		if(UserService.verifyUser(userID, pass)) {
            			userFun();
            		} else {
            			System.out.println("Invalid credentials/User not registered");
            		}
                    break;
                case 3:
                    libFun();
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.print("Do you want to continue(y/n)? ");
            char choice2 = sc.next().charAt(0);
            if(choice2 == 'n') flag = false;
        }
    }
    
    public static void userFun() {
    	Scanner sc = new Scanner(System.in);
    	UserService u = new UserService();
    	boolean flag = true;
        while(flag) {
        	System.out.println("What you want to perform?");
            System.out.println("1:Show All Books, 2:Get The Book, 3:Return The Book, 4:Edit details, 5:Sign Out");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println(UserService.viewAvailableBooks());
                    break;
                case 2:
                    System.out.print("Enter ID of the book: ");
                    String idBook = sc.next();
                    u.getBook(idBook);
                    break;
                case 3:
                    System.out.print("Enter Id of the book: ");
                    String idBook1 = sc.next();
                    u.returnBook(idBook1);
                    break;
                case 4:
//                	System.out.println("What do you want to change?(name/username/pass)");
//                	String s = sc.nextLine();
//                	
                    System.out.println("Service under maintenance");
                	break;
                case 5:
                	String[] temp = {""};
                	main(temp);
                	break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.print("Do you want to continue(y/n)? ");
            char choice = sc.next().charAt(0);
            if(choice == 'n') flag = false;
        }
    }
    
    public static void libFun() {
    	Scanner sc = new Scanner(System.in);
    	LibraryService l = new LibraryService();
    	boolean flag = true;
        while(flag) {
        	System.out.println("What you want to perform?");
            System.out.println("1:Add The Book, 2:Is Book Availaible?, 3:update The Quantity, 4:Show all Users, 5:Show all Books, 6:Remove book, 7:Sign Out");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                	sc.nextLine();
                    System.out.print("Enter the book name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID of the book: ");
                    String id = sc.nextLine();
                    System.out.print("Enter the author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter the quantity of book: ");
                    int quant = sc.nextInt();
                    Book b = new Book(id, name, author);
                    l.addBook(b, quant);
                    System.out.println("Book is Added");
                    break;
                case 2:
                    System.out.print("Enter ID of the book: ");
                    String str = sc.next();
                    if (l.isAvailable(str)) {
                        System.out.println("Hey User!...Book is availaible");
                    } else {
                        System.out.println("Sorry...The book is not currently availaible");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID of the book: ");
                    String str1 = sc.next();
                    System.out.print("Enter quantity: ");
                    int qua = sc.nextInt();
                    l.updateQuantity(str1, qua);
                    System.out.println("QUANTITY UPDATED");
                    break;
                case 4:
                	UserService.viewAllUsers();
                	break;
                case 5:
                	System.out.println(UserService.viewAvailableBooks());
                    break;
                case 6:
                	System.out.print("Enter ID of the book to remove: ");
                    String bookIdToRemove = sc.next();
                    l.removeBook(bookIdToRemove);
                    break;
                case 7:
                	String[] temp = {""};
                	main(temp);
                	break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.print("Do you want to continue(y/n)? ");
            sc.nextLine();
            char choice = sc.nextLine().charAt(0);
            if(choice == 'n') break;
        }
    }
}