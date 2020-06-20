package muzoo.io.ooc.webapp;

import java.util.HashMap;
import java.util.Map;

public class FakeDataBase {
    private Map<String,String> dataBase;

    public FakeDataBase() {
        dataBase = new HashMap<>();
        dataBase.put("Phang","2000");
    }

    public void addDataBase(String username,String password){
        dataBase.put(username, password);
    }

    public String getPassword(String username){
        return dataBase.get(username);
    }

    public boolean checkUser(String username,String password){
        return dataBase.containsKey(username) && password.equals(dataBase.get(username));
    }





}
