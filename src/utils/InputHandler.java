package utils;

import java.util.List;
import java.util.Scanner;
import main.TaskManager;


public class InputHandler
{
    private final Scanner sc;
    private final TaskManager taskManager;

    
    // Constructor
    public InputHandler(TaskManager task_manager)
    {
        this.sc = new Scanner(System.in);
        this.taskManager = task_manager;
    }


    public void DisplayMenu()
    {
        while (true) { 

            System.out.println("\n===== Task Tracker Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
    
            int choice = Integer.parseInt(this.sc.nextLine());
    
            switch (choice)
            {
            case 1:
                AddTask();
                break;

            case 2:
                ViewTasks();
                break;
            
            case 3:
                UpdateTask();
                break;
            
            case 4:
                DeleteTask();
                break;
            
            case 5:
                System.out.println("Ending Task Tracker...");
                return;
            
            default:
                System.out.println("Invalid choice! Please try again");
            }
        }
    }


    //  Calling Task Manager for different operations   //
    //-----------------------------------------
    private void AddTask()
    {
        System.out.print("\nEnter task title: ");
        String title = this.sc.nextLine();
        System.out.print("Enter task description: ");
        String desc = this.sc.nextLine();
        System.out.println();

        taskManager.AddTask(title, desc);
        System.out.println("Task added successfully!");
    }

    private void ViewTasks()
    {
        List<String> tasks = taskManager.GetAllTasks();

        if(tasks.isEmpty())
            System.out.println("No tasks are available");
        else
        {
            System.out.println("\n=== Task List ===");
            for(String task : tasks)
                System.out.println(task);
        }
    }

    private void UpdateTask()
    {
        System.out.print("\nEnter task id: ");
        int id = Integer.parseInt(this.sc.nextLine());
        System.out.print("Enter new status (Pending/Completed): ");
        String status = this.sc.nextLine();
        System.out.println();

        taskManager.UpdateTask(id, status);
        System.out.println("Task updated successfully!");
    }

    private void DeleteTask()
    {
        System.out.print("\nEnter task id: ");
        int id = Integer.parseInt(this.sc.nextLine());
        System.out.println();

        taskManager.DeleteTask(id); 
        System.out.println("Task deleted successfully!");       
    }
    //-----------------------------------------
}