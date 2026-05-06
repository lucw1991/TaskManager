package taskmanager;

import java.util.List;
import java.util.Scanner;

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
            System.out.println("1: Add Task \n2: View Tasks \n3: Exit");


            // Take in a choice from the user.
            int choice = in.nextInt();
            in.nextLine();

            // Choice navigation
            if (choice == 1) {

                System.out.println("For task creation, add a name:");

                // Take in user input for name
                String tName = in.nextLine();

                // Create the new task with the given name
                service.addTask(tName);

                // Confirm
                System.out.println("Task added!");

                // Short wait before moving on
                Thread.sleep(1500);

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

                        String ans = in.nextLine();
                        if (ans.equals("Y") || ans.equals("y") || ans.equals("yes")
                            || ans.equals("YES") || ans.equals("Yes")) {
                            stay = false;
                        } else if (ans.equals("N") || ans.equals("n") || ans.equals("no")
                                || ans.equals("NO") || ans.equals("No")) {
                            stay = true;
                        } else {
                            System.out.println("Answer must be yes or no.");
                        }
                    }
                }

            } else if (choice == 3) {

                // Exit program
                System.out.println("Goodbye!");
                isRunning = false;

            } else {
                System.out.println("Choose a correct option, 1 through 3.");
                Thread.sleep(1000);
            }

        }

    }

}