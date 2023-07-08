// Project Idea 1: Task Manager:

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask("Study Data Structures", new Date(), 3, "Complete");
        taskManager.addTask("Study Data Base", new Date(), 2, "Incomplete");
        taskManager.addTask("Mobile Application Developer", new Date(), 1, "Complete");

       // Sorting tasks by priority
        taskManager.sortTasksByPriority();

        //Updating task status
        taskManager.updateTaskStatus("Study Data Structures", "Incomplete");
        taskManager.updateTaskStatus("Mobile Application Developer", "Incomplete");

        // Displaying tasks after sorting
        taskManager.displayTasks();

        // Deleting a task
        taskManager.deleteTask("Study Data Base");

        // Displaying tasks after deletion
        taskManager.displayTasks();
    }
}