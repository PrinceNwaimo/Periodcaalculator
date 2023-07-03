package utilities;

import data.models.User;
import dtos.request.LoginUserRequest;
import dtos.response.RegisterUserResponse;

public class Mapper {
    public static User map(RegisterUserResponse registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.getDateRegistered();
        user.setPassword(registerRequest.getPassword());
        user.setEmailAddress(registerRequest.getEmailAddress());
        return user;
    }

    public static User mapAccount(LoginUserRequest loginRequest) {
        User user = new User();
        loginRequest.getUserName();
        loginRequest.getPassword();
        return user;
    }
}
