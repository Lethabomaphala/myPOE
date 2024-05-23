/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10446572.poe;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class ST10446572POE {

   
    

    public static void main(String[] args) {
        createLoginAccount();
        
    }

    public static void createLoginAccount() {

                            String name = JOptionPane.showInputDialog("Hello please enter your name");
                                                        String surname = JOptionPane.showInputDialog("Please enter your surname");


        boolean checkUsername = false;
        boolean checkPasswordComplexity = false;
        String username = "";
        String password = "";
        
        while (!checkUsername) {
                         username =
                    JOptionPane.showInputDialog(null, name + "  " +
                              "please enter a username that you would like to use for your account."
                            
                               +"  " +  "NOTE: The username must not exceed 5 character and must contain of an underscore");
            if (username != null && checkUserName(username)) {
                checkUsername = true;
            } else {
                JOptionPane.showMessageDialog(null, name + 
                          "Your Username is not correctly formatted. "
                        + "Please ensure that the username contains of an underscore and is no more than 5 characters in length" );
            } 
        } 
        JOptionPane.showMessageDialog(null, "Username successfully captured");

while (!checkPasswordComplexity) {
password =
        JOptionPane.showInputDialog(null, name + " " +
                 "please enter the password that you would like to use"
                + "  " +   "NOTE: The password must contain atleast 8 characters, it must contain of a capital letter, number and a special character");
if (password != null && isValidPassword(password)) {
    checkPasswordComplexity = true;
} else {
    JOptionPane.showMessageDialog(null, name +
              "Your password is formatted incorrectly. Please ensure that your password has atleast 8 characters"
            + ",a capital letter, number and a special character"); 
}
      
}

String registrationMessage = registerUser(username, password, name, surname);
        JOptionPane.showMessageDialog(null, registrationMessage);

        // Login process
        String inputUsername = JOptionPane.showInputDialog("Enter your username to login to your account:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password to continue logging in :");
       
        boolean isLoggedIn = loginUser(inputUsername, inputPassword, username, password);
        String loginStatus = returnLoginStatus(isLoggedIn, name, surname);
        JOptionPane.showMessageDialog(null, loginStatus);
        
    


if (isLoggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban" + " " + name+"!!!");
            boolean quit = false;
             while (!quit) {
            String[] options = {"Add Tasks", "Show Report", "Quit"};
int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Task Manager",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (choice) {

                case 0:
                    addTasks();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming soon:)");
                    break;
                case 2:
                    System.exit(0);
                }
           
            
                    

       
        }
}
    }
    

   
    public class UserRegistrationLogin {
    
   }

    private static List<Task> tasks = new ArrayList<>();
    private static int taskNumber = 0;
    private static int totalHours = 0;
    public static boolean checkUserName(String username) {
        return username != null && username.length() <=5 && username.contains("_");
    }
 public static boolean loginUser(String inputUsername, String inputPassword, String storedUsername, String storedPassword) {
        while (!inputUsername.equals(storedUsername) || !inputPassword.equals(storedPassword)) {
            inputUsername = JOptionPane.showInputDialog("Username or password incorrect, please try again. Enter username:");
            inputPassword = JOptionPane.showInputDialog("Enter password:");
        }
        return true;
    }
 public static String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName) {
        if (isLoggedIn) {
            return "Welcome back " + firstName + "  "  + "! it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
              
    }
 
     public static void addTasks() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to add?"));
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Please enter the name of your task:");
            String taskDescription = JOptionPane.showInputDialog("Enter a task description that is equal to or less than 50 characters:");

            

            String developerDetails = JOptionPane.showInputDialog("Please enter the task developer's details (First name and Last name):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration of your task (in hours):"));
            totalHours += taskDuration;
String[] statusOptions = {"1.To Do", "2.Done", "3.Doing"}; //allow the user to choose the status of the task from a dropdown menu
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Please choose the status of your task", 
                                        "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

                        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
                    developerDetails.substring(developerDetails.length() - 3).toUpperCase();//ensure the format of the task ID is autogenerated and is in all caps


            tasks.add(new Task(taskName, taskDescription, developerDetails, taskNumber, taskID));
            taskNumber++;
            
            //this pece of code will dispay the details of the task once the user is done entering the details
          String taskDetails = "Task Status: " + taskStatus + "\nDeveloper Details: " + developerDetails + 
                    "\nTask Number: " + taskNumber + "\nTask Name: " + taskName + 
                    "\nTask Description: " + taskDescription + "\nTask ID: " + taskID + 
                    "\nDuration: " + taskDuration;
            JOptionPane.showMessageDialog(null, taskDetails);
        }

        // Display total number of hours
        JOptionPane.showMessageDialog(null, "Total number of hours of all the tasks that you have created: " + totalHours);
    }
            
            
       
 

    public static boolean isValidPassword(String password) {
        if (password.length() <8) {
            return false;
        }
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) { 
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }else if (isSpecialCharacter(c)) {
                hasSpecialCharacter = true;
            }
        }
        return hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }
    public static boolean 
            isSpecialCharacter (char c) {
                String specialCharacters = "!@#$%^&*()_-+=";
                return specialCharacters.indexOf(c) != -1;
            }

      public static String registerUser(String username, String password, String firstName, String lastName) {
        while (!checkUserName(username)) {
            username = JOptionPane.showInputDialog("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. Enter username again:");
        }
        
        return "Username successfully captured\nPassword successfully captured";
    }
      
      
     
}




            




