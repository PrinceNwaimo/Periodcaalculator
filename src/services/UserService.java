package services;

import data.models.User;
import dtos.request.LoginUserRequest;
import dtos.response.FindUserResponse;
import dtos.response.RegisterUserResponse;

public interface UserService {
    User register(RegisterUserResponse registerRequest);
    void delete(User user);

    void delete(int id);


    User login(LoginUserRequest loginRequest);

    FindUserResponse findUser(String firstName, String lastName);
}
