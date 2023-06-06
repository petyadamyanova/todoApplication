import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exceptions {
        TaskList T = new TaskList();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        displayMenu();

        while (8 != choice) {
            System.out.print("Press number: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("End of program");
                    return;
                case 7:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
                    break;
            }
        }

        Task t1 = new Task("task1", "math hw");
        Task t2 = new Task("task1", "bio hw");
        Task t3 = new Task("task1", "oop hw");


        T.addTask(t1);
        T.addTask(t2);
        T.addTask(t3);

        try{
            T.completeTask(4);
        }catch (Exceptions e){
            System.out.println(e.getMessage());
        }

        T.addTask("mat test", "important");

        //T.printAllTasks();

    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("Add task - press 1");
        System.out.println("Complete task - press 2");
        System.out.println("Remove task - press 3");
        System.out.println("Edit task - press 4");
        System.out.println("View all task - press 5");
        System.out.println("View menu - press 7");
        System.out.println("Exit - press 8\n");
    }
}