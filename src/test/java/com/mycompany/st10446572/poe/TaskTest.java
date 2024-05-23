/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10446572.poe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testSomeMethod() {
    }
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


    @Test
    public void testTaskDescription_LengthValidation() {
        String validDescription = "Create Login to authenticate users";
        String invalidDescription = "This description is way exceeds the fifty characters limit imposed by the system";

        assertTrue(Task.checkTaskDescription(validDescription));
        assertFalse(Task.checkTaskDescription(invalidDescription));
    }

    @Test
    public void testGenerateTaskID() {
        Task.resetTaskCounter() ;

        Task task1 = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:1:SON", task1.getTaskID());

        Task task2 = new Task("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:2:ITH", task2.getTaskID());
    }

    @Test
    public void testCalculateTotalHours() {
        int[] taskDuration1 = {10, 12, 55, 11, 1};
        int[] taskDuration2 = {8, 10};

        assertEquals(89, Task.calculateTotalHours(taskDuration1));
        assertEquals(18, Task.calculateTotalHours(taskDuration2));
    }

    @Test
    public void testTaskIDLoop() {
        Task.resetTaskCounter();

        Task task1 = new Task("CR", "Test task 1", "Mike", 10, "To Do");
        Task task2 = new Task("CR", "Test task 2", "Ard", 10, "To Do");
        Task task3 = new Task("CR", "Test task 3", "Tha", 10, "To Do");
        Task task4 = new Task("CR", "Test task 4", "And", 10, "To Do");

        assertEquals("CR:1:IKE", task1.getTaskID());
        assertEquals("CR:2:ARD", task2.getTaskID());
        assertEquals("CR:3:THA", task3.getTaskID());
        assertEquals("CR:4:AND", task4.getTaskID());
    }
}
    


    

