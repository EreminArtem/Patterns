package lesson6;

import java.sql.SQLException;
import java.util.Map;

public class Repository {

    private Map<Integer, User> userList;

    public Repository() throws SQLException {
        this.userList = Mapper.getInstance().findAll();
    }

    public Map<Integer, User> getUserList() {
        return userList;
    }

    public void addUser(final User user) throws SQLException {
        Mapper.getInstance().createNewUser(user);
        this.userList = Mapper.getInstance().findAll();
    }

    public User getUserById(final int id) {
        return this.userList.get(id);
    }
}
