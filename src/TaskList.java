import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title, String description){
        Task t = new Task(title, description);
        this.tasks.add(t);

    }

    public boolean checkIfTaskExist(int taskId){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                return true;
            }
        }

        return false;
    }

    public Task getTask(int taskId){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                return t;
            }
        }

        return null;
    }

    public void changeTaskTitle(int taskId, String newTitle){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                t.setTitle(newTitle);
            }
        }
    }

    public void changeTaskDescription(int taskId, String newDescription){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                t.setDescription(newDescription);
            }
        }
    }

    public void changeTaskPriority(int taskId, PriorityLevel newLevel){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                if(t instanceof TaskWithPriority){
                    ((TaskWithPriority) t).setLevel(newLevel);
                }
            }
        }
    }

    public void changeTaskDeadline(int taskId, LocalDate newDeadLine){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                if(t instanceof TaskWithDeadline){
                    ((TaskWithDeadline) t).setDeadline(newDeadLine);
                }
            }
        }
    }

    public void changeTaskStatus(int taskId){
        for(Task t : tasks){
            if(t.get_id() == taskId){
                if(t.isCompleted()){
                   t.markAsIncomplete();
                }else{
                    t.markAsCompleted();
                }
            }
        }
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
