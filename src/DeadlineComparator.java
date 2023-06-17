import java.util.Comparator;

public class DeadlineComparator implements Comparator<TaskWithDeadline>{
    @Override
    public int compare(TaskWithDeadline task1, TaskWithDeadline task2) {
        return task1.getDeadline().compareTo(task2.getDeadline());
    }
}