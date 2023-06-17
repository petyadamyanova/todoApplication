import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exceptions, ParseException {
        TaskList T = new TaskList();
        T.setTasks(TaskListSerializer.loadTaskList());
        Task.setIdCount(TaskListSerializer.getLastTaskId(T.getTasks()));
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        displayMenu();

        while (10 != choice) {
            System.out.print("Press number: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int taskType;
                    String title, description;
                    System.out.print("Press 1 - to add task \nPress 2 - to add task with deadline \nPress 3 to add task with priority \n");
                    System.out.print("Press number: ");
                    taskType = scanner.nextInt();

                    if(taskType != 1 && taskType != 2 && taskType != 3 ){
                        System.out.println("This was not a valid option.");
                        break;
                    }

                    System.out.print("Enter task title: ");
                    title = String.valueOf(scanner.next());

                    System.out.print("Enter task description: ");
                    description = String.valueOf(scanner.next());

                    if(taskType == 2){
                        System.out.print("Enter task deadline: ");
                        String d;
                        LocalDate date = null;
                        d = scanner.next();

                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        try {
                            date = LocalDate.parse(d, dateFormatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Not valid format of data!");
                        }

                        TaskWithDeadline t = new TaskWithDeadline(title, description, date);
                        T.addTask(t);
                    }else if (taskType == 3){
                        int num;
                        System.out.print("Enter task priority level: ");
                        System.out.print("\nPress 1 - for low \nPress 2 - for medium \nPress 3 - for high ");
                        System.out.print("\nEnter number: ");

                        num = scanner.nextInt();

                        PriorityLevel newPriority;

                        if(num == 1){
                            newPriority = PriorityLevel.LOW;
                        }else if(num == 2){
                            newPriority = PriorityLevel.MEDIUM;
                        }else if(num == 3){
                            newPriority = PriorityLevel.HIGH;
                        }else{
                            System.out.println("This was not a valid option.");
                            break;
                        }
                        TaskWithPriority t = new TaskWithPriority(title, description, newPriority);
                        T.addTask(t);
                    }else{
                        Task t = new Task(title, description);
                        T.addTask(t);
                    }

                    break;
                case 2:
                    int taskId;
                    System.out.print("Enter task id: ");
                    taskId = scanner.nextInt();

                    try{
                        T.completeTask(taskId);
                    }catch (Exceptions e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    int taskid = 0;
                    System.out.print("Enter task id: ");
                    taskid = scanner.nextInt();

                    T.removeTask(taskid);
                    break;
                case 4:
                    int task_id = 0;
                    System.out.print("Enter task id of a task you want to edit: ");
                    task_id = scanner.nextInt();
                    int num;
                    int flag = 0 ; // to check if task is with priority or deadline

                    if(!T.checkIfTaskExist(task_id)){
                      System.out.println("There is no task with id : " + task_id);
                      break;
                    }

                    System.out.print("Enter task field you want to edit: ");
                    System.out.print("\nPress 1 - for title \nPress 2 - for description \nPress 3 - for status");

                    if(T.getTask(task_id) instanceof TaskWithDeadline){
                        System.out.print("\nPress 4 - for deadline ");
                        flag = 1;
                    }

                    if(T.getTask(task_id) instanceof TaskWithPriority){
                        System.out.print("\nPress 4 - for priority ");
                        flag = 1;
                    }

                    System.out.print("\nEnter number: ");
                    num = scanner.nextInt();

                    if(num != 1 && num != 2 && num != 3 && flag == 0){
                        System.out.println("This was not a valid option.");
                        break;
                    }else if(num != 1 && num != 2 && num != 3 && num != 4 && flag == 1){
                        System.out.println("This was not a valid option.");
                        break;
                    }

                    if(num == 1){
                        String newTitle;
                        System.out.print("\nEnter new title: ");
                        newTitle = String.valueOf(scanner.next());

                        T.changeTaskTitle(task_id, newTitle);
                    }else if(num == 2){
                        String newDescription;
                        System.out.print("\nEnter new description: ");
                        newDescription = String.valueOf(scanner.next());

                        T.changeTaskDescription(task_id, newDescription);
                    } else if(num == 3){
                        T.changeTaskStatus(task_id);
                    } else if(num == 4){
                        if(T.getTask(task_id) instanceof TaskWithPriority){
                            int n;
                            System.out.print("Enter new task priority level: ");
                            System.out.print("\nPress 1 - for low \nPress 2 - for medium \nPress 3 - for high ");
                            System.out.print("\nEnter number: ");

                            n = scanner.nextInt();

                            PriorityLevel newPriority;

                            if(n == 1){
                                newPriority = PriorityLevel.LOW;
                            }else if(n == 2){
                                newPriority = PriorityLevel.MEDIUM;
                            }else if(n == 3){
                                newPriority = PriorityLevel.HIGH;
                            }else{
                                System.out.println("This was not a valid option.");
                                break;
                            }

                            T.changeTaskPriority(task_id, newPriority);
                        }else if(T.getTask(task_id) instanceof TaskWithDeadline){
                            System.out.print("Enter new task deadline: ");
                            String d_;
                            LocalDate date_ = null;
                            d_ = scanner.next();

                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                            try {
                                date_ = LocalDate.parse(d_, dateFormatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("Not valid format of data!");
                            }

                            T.changeTaskDeadline(task_id, date_);
                        }
                    }

                    break;
                case 5:
                    System.out.println("5");
                    T.printAllTasks();
                    break;
                case 6:
                    T.sortTaskByDeadline();
                    break;
                case 7:
                    T.sortTaskByPriority();
                    break;
                case 8:
                    String str;
                    System.out.print("Enter string: ");
                    str = scanner.next();

                    T.filterStartingWith(str);
                    break;
                case 9:
                    displayMenu();
                    break;
                case 10:
                    TaskListSerializer.saveTaskList(T.getTasks());
                    System.out.println("End of program");
                    return;
                default:
                    System.out.println("Invalid option. Try again!");
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("Add task - press 1");
        System.out.println("Complete task - press 2");
        System.out.println("Remove task - press 3");
        System.out.println("Edit task - press 4");
        System.out.println("View all task - press 5");
        System.out.println("View task with deadline - press 6");
        System.out.println("View tasks with priority - press 7");
        System.out.println("Searching for task begging with string - press 8");
        System.out.println("View menu - press 9");
        System.out.println("Exit - press 10\n");
    }
}