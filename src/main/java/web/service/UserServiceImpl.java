package web.service;

import web.dao.UserDao;
import web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }
    @Transactional
    @Override
    public void addUser(User user) { dao.addUser(user); }
    @Transactional
    @Override
    public List<User> getAllUsers() { return dao.getAllUsers(); }
    @Transactional
    @Override
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }
    @Transactional
    @Override
    public void updateUser(long id, User user) { dao.updateUser(id, user); }
    @Transactional
    @Override
    public User findUser(long id) { return dao.findUser(id); }
}
