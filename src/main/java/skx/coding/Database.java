package skx.coding;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users;
    public Database() {
        users = new ArrayList<>();
        loadUsers();
    }
    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void saveUsers() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("Users.json"), users);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadUsers() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            File file = new File("Users.json");
            if (file.exists()){
                users = mapper.readValue(file,mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}