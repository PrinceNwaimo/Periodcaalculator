package services;

import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImplementation;
import dtos.request.LoginUserRequest;
import dtos.response.FindUserResponse;
import dtos.response.RegisterUserResponse;
import utilities.Mapper;

public class UserServiceImplementation implements UserService{
    UserRepository userRepository = new UserRepositoryImplementation();

    @Override
    public User register(RegisterUserResponse registerRequest) {
        if (userExists(registerRequest.getEmailAddress())) throw new IllegalArgumentException("User already exists");
        return userRepository.save(Mapper.map(registerRequest));
    }
    private boolean userExists(String emailAddress){
        User found = userRepository.findByEmailAddress(emailAddress);
        if (found != null)
            return true;
        else return false;
    }


    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User login(LoginUserRequest loginRequest) {
        User foundUser = userRepository.findByEmailAddress(loginRequest.getUserName());
//       Object existingUser = userRepository.findByEmailAddress(loginRequest.getPassword());
//       if (foundUser.isEmpty())throw new IllegalArgumentException("Email does not exist");
        if (foundUser!= null)throw new IllegalArgumentException("Account does not exist");
//        if (foundUser.getPassword().equals(loginRequest.getPassword()))throw new IllegalArgumentException("Password incorrect");
//        if(existingUser != null)throw new IllegalArgumentException("Email does not exist");
//       LoginUser response = new LoginUser();
//       Mapper.mapAccount(foundUser.get(),response);
        return userRepository.save(Mapper.mapAccount(loginRequest));
    }
    private boolean userDoesExist(String emailAddress){
        Object found = userRepository.findByEmailAddress(emailAddress);
        return found != null;
    }



    @Override
    public FindUserResponse findUser(String firstName, String lastName) {
        User user = userRepository.findByFirstAndLastName(firstName, lastName);
        if(user == null)throw new IllegalArgumentException("User does not exist");
        FindUserResponse response = new FindUserResponse();
        response.setFullName(user.getFirstName()+ user.getLastName());
        response.setEmailAddress(user.getEmailAddress());

        return response;
    }
}
