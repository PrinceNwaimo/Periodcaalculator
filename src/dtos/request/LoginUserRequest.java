package dtos.request;

public class LoginUserRequest {

    private String password;

    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginUserRequest{" +
                "password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
