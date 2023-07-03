import controller.PeriodCycleController;
import controller.UserController;
import dtos.request.CalculateNextPeriodDateRequest;
import dtos.request.CalculateOvulationDateRequest;
import dtos.request.LoginUserRequest;
import dtos.request.SafePeriodRequest;
import dtos.response.RegisterUserResponse;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    private static UserController userController = new UserController();

    private static PeriodCycleController cycleController = new PeriodCycleController();
    public static void main(String[] args) {
        startApp();
    }
    private static void startApp(){
        String message = """
                Kerb Digital Period Checker
                ===========================
                1>>> Register
                ============================
                2>>> Login
                ============================
                3>>> Exit Application
                ============================
            
                
                """;
        String input = input(message);
        switch (input.charAt(0)){
            case '1'-> register();
            case '2'-> login();
            case '3'-> exitApplication();
            default -> {
                display("Wrong selection");


            }
        }

    }
    private static void displayAfterLogin(){

        String message = input("""
                        1 = Check Next Period date
                        2 = Calculate Ovulation Period
                        3 = Safe Period Estimation
                        4 = Log out""");

        
       
        switch (message.charAt(0)) {
            case '1' ->calculateNextPeriodDate();
            case '2' ->calculateOvulationDate();
            case '3' ->safePeriod();
            case '4' ->startApp();
        }



    }
    private static  void display(String message){
        JOptionPane.showMessageDialog(null,message);

    }
    private static void register(){
        RegisterUserResponse request = new RegisterUserResponse();
        request.setFirstName(input("First name"));
        request.setLastName(input("Last Name"));
        request.setEmailAddress(input("Enter your email address"));
        request.setUserName(input("Enter a preferred user name"));
        request.setPassword(input("Enter your password"));
        var user = userController.register(request);
        display(user.toString());
//        display(request.toString());
        display("Account created successfully");
        startApp();
    }
    public static String input (String prompt){return JOptionPane.showInputDialog(prompt);}

    private static void login(){
        LoginUserRequest request = new LoginUserRequest();
        request.setUserName(input("Enter your userName"));
        request.setPassword(input("Enter your password"));

        try {
            var pick = userController.login(request);
            display("Logging in...............");
            displayAfterLogin();
        }catch (NullPointerException e){
            display(e.getMessage());}
        startApp();

    }
    private static void calculateNextPeriodDate(){
        CalculateNextPeriodDateRequest calculator = new CalculateNextPeriodDateRequest();
        calculator.setDateOfBirth((input("Date of Birth(dd/MM/yyyy):")));
        calculator.setCycleLength(Integer.parseInt(input("Enter the length of your menstrual cycle in days: ")));
        calculator.setLastPeriodDate(input("Enter the date of the first day of your last period (YYYY-MM-DD): "));
        display(calculator.toString());
        displayAfterLogin();

    }
    private static void calculateOvulationDate(){
        CalculateOvulationDateRequest calculator = new CalculateOvulationDateRequest();
        calculator.setDateOfBirth(input("Date of Birth(dd/MM/yyyy):"));
        calculator.setCycleLength(Integer.parseInt(input("Enter the length of your menstrual cycle in days: ")));
        calculator.setLastPeriodDate(input("Enter the date of the first day of your last period (YYYY-MM-DD): "));
        display(calculator.toString());
        displayAfterLogin();
    }
    private static void safePeriod(){
        SafePeriodRequest calculator = new SafePeriodRequest();
        calculator.setDateOfBirth(input("Date of Birth(dd/MM/yyyy):"));
        calculator.setCycleLength(Integer.parseInt(input("Enter the length of your menstrual cycle in days: ")));
        calculator.setLastPeriodDate(input("Enter the date of the first day of your last period (dd/MM/yyyy): "));
        display(calculator.toString());
        displayAfterLogin();
    }
    private static void exitApplication() {
        display("Thanks for using this application.");
        System.exit(1);
    }
    }