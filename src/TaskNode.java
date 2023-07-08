import java.util.Date;

class TaskNode {
    String taskName;
    Date dueDate;
    int priority;
    String status;
    TaskNode next;
    TaskNode previous;

    public TaskNode(String taskName, Date dueDate, int priority, String status) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

}