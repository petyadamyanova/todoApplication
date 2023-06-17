import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskListSerializer {
    private static final String FILE_PATH = "tasklist.ser";

    public static void saveTaskList(List<Task> taskList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error with saving task file : " + e.getMessage());
        }
    }

    public static List<Task> loadTaskList() {
        List<Task> taskList = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            taskList = (List<Task>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error with reloading tasks from : " + e.getMessage());
        }
        return taskList;
    }

    public static int getLastTaskId(List<Task> taskList) {
        if (taskList.isEmpty()) {
            return 0; // връщаме 0, ако няма задачи в списъка
        }
        Task lastTask = taskList.get(taskList.size() - 1);
        return lastTask.get_id();
    }
}





