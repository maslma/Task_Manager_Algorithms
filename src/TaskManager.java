import java.util.Date;
class TaskManager {
    TaskNode head;
    TaskNode tail;

    public void addTask(String taskName, Date dueDate, int priority, String status) {
        TaskNode newTask = new TaskNode(taskName, dueDate, priority, status);

        if (head == null) {
            head = newTask;
            tail = newTask;
        } else {
            TaskNode current = head;
            while (current != null && current.priority >= newTask.priority) {
                current = current.next;
            }
            if (current == null) {
                newTask.previous = tail;
                tail.next = newTask;
                tail = newTask;
            } else if (current == head) {
                newTask.next = head;
                head.previous = newTask;
                head = newTask;
            } else {
                newTask.next = current;
                newTask.previous = current.previous;
                current.previous.next = newTask;
                current.previous = newTask;
            }
        }
    }

    public void updateTaskStatus(String taskName, String newStatus) {
        TaskNode current = head;
        while (current != null) {
            if (current.taskName.equals(taskName)) {
                current.status = newStatus;
                break;
            }
            current = current.next;
        }
    }

    public void deleteTask(String taskName) {
        TaskNode current = head;
        while (current != null) {
            if (current.taskName.equals(taskName)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                break;
            }
            current = current.next;
        }
    }

    public void sortTasksByPriority() {
        if (head == null || head == tail) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            TaskNode current = head;
            while (current != null && current.next != null) {
                if (current.priority > current.next.priority) {
                    swapNodes(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    private void swapNodes(TaskNode node1, TaskNode node2) {
        if (node1.previous == null) {
            head = node2;
        } else {
            node1.previous.next = node2;
        }

        if (node2.next == null) {
            tail = node1;
        } else {
            node2.next.previous = node1;
        }

        node1.next = node2.next;
        node2.previous = node1.previous;

        node1.previous = node2;
        node2.next = node1;
    }

    public void displayTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println("Task: " + current.taskName);
            System.out.println("Due Date: " + current.dueDate);
            System.out.println("Priority: " + current.priority);
            System.out.println("Status: " + current.status);
            System.out.println("-----------------------------------------------");
            current = current.next;
        }
    }
}