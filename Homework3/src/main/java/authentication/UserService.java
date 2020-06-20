package authentication;

import muzoo.io.ooc.webapp.FakeDataBase;

public class UserService {
    private FakeDataBase fakeDataBase;

    public UserService(FakeDataBase fakeDataBase) {
        this.fakeDataBase = fakeDataBase;
    }

    public User getUserByUsername(String username){
        return new User(username,fakeDataBase.getPassword(username));
    }
    public void addUser(String user,String password){
        fakeDataBase.addDataBase(user,password);
    }



}
