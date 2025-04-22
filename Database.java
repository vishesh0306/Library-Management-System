import java.util.HashMap;

public class Database {

    
    HashMap<Books, Integer> hashmap = new HashMap<>();
    
    {
        Books b1 = new Books("123", "Ramayan", "Valmiki");
        hashmap.put(b1, 6);
    }

    Users[] users = new Users[8];

    Librarian[] librarians = new Librarian[2];

    

}



