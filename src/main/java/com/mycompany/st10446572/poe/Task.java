/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10446572.poe;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
   
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    private static int taskCount = 0;
    
    public Task(String taskName, String taskDescription, String developerDetails, int taskNumber, String taskID) {
   this.taskName = taskName;
    this.taskNumber = taskNumber;
    this.taskDescription = taskDescription;
    this.developerDetails = developerDetails;
    this.taskDuration = taskDuration;
    this.taskID = taskID;
    this.taskStatus = taskStatus;
    this.taskID = generateTaskID();
    taskCount++;
}

public static String validateDescription (String description) {
if (description.length() <= 50) {
                return   "Task successfully captured";

            } else {
return "Please enter a task description of less than 50 characters";
            }
}

private String generateTaskID() {
String taskID = taskName.substring(0, 2).toUpperCase()+ ":" + taskCount + ":" +
        developerDetails.substring(developerDetails.length() - 3).toUpperCase();
return taskID;

}

public static int calculateTotalHours(int [] taskDuration) {
    int total = 0;
    for (int duration : taskDuration) {
        
    }
    return total;
}

public static boolean checkTaskDescription(String description)
{
    return description.length()<= 50;
}

public static void resetTaskCounter() {
    int taskCounter = 0;
}

public String getTaskName() {
    return taskName;
}

public void setTaskName(String taskName) {
    this.taskName = taskName;
}

public int getTaskNumber() {
    return taskNumber;
}

public void setTaskNUmber(int taskNumber) {
    this.taskNumber = taskNumber;
    
}

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}


    

