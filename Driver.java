import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================================");
        System.out.println("\t\t\tWelcome to Library");
        System.out.println("==================================================================");

        System.out.println();

        System.out.println("Press 1: Login as User \n Press 2: Login as Librarian");
        System.out.println();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:{
                try{
                    System.out.print("Enter UserID: ");
                    String id = scanner.next();
                    System.out.println();
                    System.out.print("Enter password: ");
                    String pass = scanner.next();
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }

            break;
            }

            case 2:{
                try{
                    System.out.print("Enter UserID: ");
                    String id = scanner.next();
                    System.out.println();
                    System.out.print("Enter password: ");
                    String pass = scanner.next();
                    System.out.println();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            break;
            }
                
        
            default:
                break;
        }



    }

}
