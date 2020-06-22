package authentication;


import DataBase.DataBase;
import HashAndSalt.BCrypt;
import muzoo.io.ooc.webapp.FakeDataBase;
import java.sql.*;
import java.util.List;


public class UserService {
    private DataBase dataBase;
    private BCrypt bCrypt;

    public UserService() {
        this.dataBase = new DataBase();
        this.bCrypt = new BCrypt();

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
    public boolean checkRepeatedUN(String username){
       return dataBase.checkRepeatedUserName(username);

    }
    public String hashSaltCal(String password){
        return bCrypt.hashSaltConversion(password);
    }
    public boolean checkPassword(String original,String hash){
        return bCrypt.isMatched(original,hash);
    }
    public String getPWD(String userName){
        return dataBase.getPassword(userName);
    }


}
