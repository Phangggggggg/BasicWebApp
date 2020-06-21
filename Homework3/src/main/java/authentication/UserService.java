package authentication;


import DataBase.DataBase;
import muzoo.io.ooc.webapp.FakeDataBase;
import java.sql.*;
import java.util.List;


public class UserService {
    private DataBase dataBase;

    public UserService() {
        this.dataBase = new DataBase();
    }

    public boolean checkUser(String username, String password){
        return this.dataBase.checkUser(username, password);
    }
    public void addUser(String name, String username,String password) throws ClassNotFoundException, SQLException {
        dataBase.addDatabase(name,username,password);
    }

    public List<User> getAllUser() {
        return dataBase.getAllUser();
    }
    public void removeUser(String username){
        dataBase.deleteUser(username);
    }
    public void editUser(String targetName, String editName){
        dataBase.editNameofUser(targetName,editName);

    }

}
