package taskmanager;

import java.util.List;
import java.util.Scanner;

import enums.Status;
import models.Task;
import services.TaskService;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Task service
        TaskService service = new TaskService();

        // Tasks list
        List<Task> tList = service.getTasks();

        // Scanner object for user input
        Scanner in = new Scanner(System.in);

        // Running boolean for exiting
        boolean isRunning = true;

        // Boolean to stay or leave option page
        boolean stay = true;


        while (isRunning) {

            // Stay set to true at the main menu each time.
            stay = true;

            // Main menu
            System.out.print("Welcome! Begin managing your tasks:\n...\n...\n");

            System.out.println("What do you want to do?");
            System.out.println("1: Add Task \n2: View Tasks \n3: Update Task \n4: Delete Task \n5: Exit");


            // Take in a choice from the user.
            int choice = in.nextInt();
            in.nextLine();

            // Choice navigation
            if (choice == 1) {

                System.out.println("For task creation, add a name:");

                // Take in user input for name
                String tName = in.nextLine();

                // Create the new task with the given name
                if (service.addTask(tName)) {
                    // Confirm
                    System.out.println("Task added!");

                    // Short wait before moving on
                    Thread.sleep(500);
                }

            } else if (choice == 2) {

                while (stay) {
                    if (tList.isEmpty()) {
                        System.out.println("No tasks yet.");
                        stay = false;
                    } else {
                        for (Task t : tList) {
                            // Use getName to print the name. getName and status in models/Task.java
                            System.out.println(t.getName() + ", " + t.getStatus());
                        }
                        System.out.println("Would you like to go back to the main page? Just Y/N");
                        Thread.sleep(500);

                        String ans = in.nextLine();
                        if (ans.equals("Y") || ans.equals("y") || ans.equals("yes")
                            || ans.equals("YES") || ans.equals("Yes")) {
                            stay = false;
                        } else if (ans.equals("N") || ans.equals("n") || ans.equals("no")
                                || ans.equals("NO") || ans.equals("No")) {
                            stay = true;
                        } else {
                            System.out.println("Answer must be yes or no.");
                            Thread.sleep(500);
                        }
                    }
                }

            } else if (choice == 3) {

                // Boolean to track updates
                boolean isUpdated = false;


                // Check if the list is empty first
                if (tList.isEmpty()) {
                    System.out.println("List is empty!");
                    Thread.sleep(500);
                } else {

                    // Print list of tasks
                    for (Task t : tList) {
                        System.out.println("Task: " + t.getName() + " " + t.getStatus());
                    }

                    // Ask which to update
                    System.out.println("Which task status would you like to update?\n");
                    String ans = in.nextLine();

                    // Check if in the list,
                    for (Task task : tList) {

                        // If the input is present as a task name
                        if (task.getName().equals(ans)) {

                            // Ask what to update to
                            System.out.println("Update to what: ");
                            System.out.println("1: In Progress \n2: For later \n3: Complete \nChoose 1, 2, or 3");

                            // Take int value to status type
                            int status = in.nextInt();

                            // Take care of left over blank line after nextInt().
                            in.nextLine();

                            // Apply status
                            if (status == 1) {
                                service.updateTask(task.getName(), Status.IN_PROGRESS);
                            } else if (status == 2) {
                                service.updateTask(task.getName(), Status.PENDING);
                            } else if (status == 3) {
                                service.updateTask(task.getName(), Status.COMPLETE);
                            }

                            System.out.println("Task has been updated!");
                            isUpdated = true;
                            Thread.sleep(500);
                        }
                    }

                    // If not found and isUpdated stays false, print the message.
                    if (!isUpdated) {
                        System.out.println("Task not found!");
                        Thread.sleep(500);
                    }

                }

            } else if (choice == 4) {

                // Display list but check if empty first
                if (tList.isEmpty()) {
                    System.out.println("List is empty!");
                    Thread.sleep(500);
                } else {

                    for (Task t : tList) {
                        System.out.println("Task: " + t.getName() + " " + t.getStatus());
                    }

                    System.out.println("Which task would you like to delete?");
                    String ans = in.nextLine();

                     if (service.deleteTask(ans)) {
                         System.out.println("Task removed!");
                         Thread.sleep(500);
                     } else {
                         System.out.println("Task not found!");
                     }

                }

            } else if (choice == 5) {

                // Exit program
                System.out.println("Goodbye!");
                isRunning = false;

            } else {
                System.out.println("Choose a correct option, 1 through 5.");
                Thread.sleep(1000);
            }

        }

    }

}