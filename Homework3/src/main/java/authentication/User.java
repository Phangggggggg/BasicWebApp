package authentication;

public class User {
    private int id;
    private String userName;
    private String password;
    private String name;

    public User () {}

    public User(String name,String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
