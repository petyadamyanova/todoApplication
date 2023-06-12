import java.util.Comparator;

public class PriorityComparator implements Comparator<TaskWithPriority> {
    @Override
    public int compare(TaskWithPriority task1, TaskWithPriority task2) {
        if(task1.getLevel() == "Low"){
            return 1;
        }

        if(task1.getLevel() == "Medium" && task2.getLevel() != "High"){
            return -1;
        }else if(task1.getLevel() == "Medium" && task2.getLevel() == "High"){
            return 1;
        }

        if(task1.getLevel() == "High"){
            return -1;
        }

        return 0;
    }
}