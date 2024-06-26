package it.ioprogrammatore.task;

import it.ioprogrammatore.task.models.Task;
import it.ioprogrammatore.task.models.TaskManager;
import it.ioprogrammatore.task.utils.TaskUtils;

import java.util.List;

public class TaskManagementSystem {

    public static void main(String[] args) {
        TaskManager taskManager = getTaskManager();

        // Print all tasks
        System.out.println("All Tasks:");
        taskManager.printAllTasks();

        // Print tasks due today or overdue
        System.out.println("\nTasks Due Today or Overdue:");
        taskManager.printTasksDueTodayOrOverdue();

        System.out.println("---------------------------------------");
        //Test Random method
        System.out.println("All Tasks with Rand method:");
        TaskManager taskManagerRnd = getTaskManagerRand();
        taskManagerRnd.printAllTasks();

        // Test Random method due today or overdue
        System.out.println("\nTasks Due Today or Overdue:");
        taskManager.printTasksDueTodayOrOverdue();

    }

    // Manual insert
    private static TaskManager getTaskManager() {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask("Complete the project report", "2024-06-28", 1);
        taskManager.addTask("Buy groceries", "2024-06-25", 2);
        taskManager.addTask("Doctor's appointment", "2024-06-26", 3);
        taskManager.addTask("Pay bills", "2024-06-27", 1);
        taskManager.addTask("Team meeting", "2024-06-24", 3);
        taskManager.addTask("Submit assignment", "invalid-date", 2); // This will cause an exception
        return taskManager;
    }

    // Random insert
    private static TaskManager getTaskManagerRand() {
        TaskManager taskManager = new TaskManager();

        List<Task> tasks = TaskUtils.generateTasksList(10);
        taskManager.addAllTasks(tasks);

        return taskManager;
    }


}
