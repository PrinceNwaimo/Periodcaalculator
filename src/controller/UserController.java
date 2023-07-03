package controller;

import data.models.User;
import dtos.request.LoginUserRequest;
import dtos.response.RegisterUserResponse;
import services.UserService;
import services.UserServiceImplementation;

public class UserController {

    private UserService userServices = new UserServiceImplementation();

    public Object register(RegisterUserResponse request) {
        try{
            return userServices.register(request);
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    public User login(LoginUserRequest request){
        try{
            return userServices.login(request);

        }catch(IllegalArgumentException ex){
            throw new NullPointerException("Enter valid credentials");
        }

    }
    public Object findUser(String firstName, String lastName){
        try{
            return userServices.findUser(firstName, lastName);
        }
        catch (IllegalArgumentException ex){
            return ex.getMessage();
        }

    }
}
