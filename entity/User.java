package project.LibraryManagementSystem.entity;

public class User{
    String name;
    String userID;
    String password;

    User(String name, String userID, String password){
        this.name = name;
        this.password = password;
        this.userID = userID;
    }

}
