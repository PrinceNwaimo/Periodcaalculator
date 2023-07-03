package data.repository;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplementation implements UserRepository{
    private  int count;

    private List<User>users = new ArrayList<>();
    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if (userHasNotBeenSaved) saveNew(user);
//        user.setId(generateUserId());
//        users.add(user);
        count++;
        return user;
    }

    private void saveNew(User user) {
        user.setId(generateUserId());
        users.add(user);

    }

    private int generateUserId() {
        return count + 1;
    }


    @Override
    public User findById(int id) {
        for (User user : users)
            if (user.getId() == id) return user;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        for (User user : users) {
            if (user.getEmailAddress() == emailAddress) {
                return user;
            }

        }
//        System.out.println(users);
        return null;
    }

    @Override
    public User findByFirstAndLastName(String firstName, String lastName) {
        for (User user : users) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                return user;
            }

        }
        return null;
    }
    }

