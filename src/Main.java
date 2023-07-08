// Project Idea 1: Task Manager:

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask("Complete project report", new Date(), 2, "Incomplete");
        taskManager.addTask("Schedule meeting with team", new Date(), 1, "Incomplete");
        taskManager.addTask("Buy groceries", new Date(), 3, "Incomplete");

//         Updating task status
        taskManager.updateTaskStatus("Complete project report", "Completed");

        // Sorting tasks by priority
        taskManager.sortTasksByPriority();

        // Displaying tasks after sorting
        taskManager.displayTasks();

        // Deleting a task
        taskManager.deleteTask("Buy groceries");

        // Displaying tasks after deletion
        taskManager.displayTasks();
    }
}