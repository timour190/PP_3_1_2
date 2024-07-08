package com.example.PP_3_1_2.userDAO;

import com.example.PP_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private final EntityManager entityManager;


    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> list() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User user(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        if (!user.getName().isBlank() && !user.getLastName().isBlank()) {
            entityManager.persist(user);
            entityManager.flush();
        }
    }


    public void update(User user, int id) {
        if (!user.getName().isBlank() && !user.getLastName().isBlank()) {
            entityManager.merge(user);
            entityManager.flush();
        }
    }

    public void delete(int id) throws NullPointerException {
        User user = user(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }
}