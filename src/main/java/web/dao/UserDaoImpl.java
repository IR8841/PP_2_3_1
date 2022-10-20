package web.dao;

import web.entity.User;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) { entityManager.persist(user); }
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public void deleteUser(long id) { entityManager.remove(findUser(id));}
    @Override
    public void updateUser(long id, User user) {
        User targetUser = findUser(id);
        targetUser.setName(user.getName());
        targetUser.setAge(user.getAge());
        targetUser.setEmail(user.getEmail());
        entityManager.merge(targetUser);
    }
    @Override
    public User findUser(long id) { return entityManager.find(User.class, id); }

}