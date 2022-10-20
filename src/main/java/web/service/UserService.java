package web.service;

import web.entity.User;
import org.springframework.ui.ModelMap;

import java.util.List;


public interface UserService {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(long id);

    public void updateUser(long id, User user);

    public User findUser(long id);
}
