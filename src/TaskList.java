import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String title, String description){
        Task t = new Task(title, description);
        this.tasks.add(t);

    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int taskId){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                tasks.remove(t);
                return;
            }
        }

        System.out.println("There is no task with this id!");
    }

    public void printAllTasks(){
        for(Task t : tasks){
            t.printTask();
            System.out.println();
        }
    }

    public void filterStartingWith(String string){
        for(Task t : tasks){
            if(t.getTitle().startsWith(string)){
                t.printTask();
                System.out.println();
            }
        }
    }

    public void sortTaskByPriority(){
        List<TaskWithPriority> result = new ArrayList<>();

        for(Task t : tasks){
            if(t instanceof TaskWithPriority){
                result.add((TaskWithPriority) t);
            }
        }

        result.sort(new PriorityComparator());

        for(Task t : result){
            t.printTask();
            System.out.println();
        }
    }

    public void sortTaskByDeadline(){
        List<TaskWithDeadline> result = new ArrayList<>();

        for(Task t : tasks){
            if(t instanceof TaskWithDeadline){
                result.add((TaskWithDeadline) t);
            }
        }

        result.sort(new DeadlineComparator());

        for(Task t : result){
            t.printTask();
            System.out.println();
        }
    }

    public int taskCount(){
        return tasks.size();
    }

    public void completeTask(int taskId) throws Exceptions {
        for(Task t : this.tasks){
            if(t.get_id() == taskId){
                t.markAsCompleted();
                return;
            }
        }

        throw new Exceptions("There is no task with " + taskId + " id");
    }

}
