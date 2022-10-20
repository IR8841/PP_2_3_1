package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(long id);

    public void updateUser(long id, User user);

    public User findUser(long id);


}
