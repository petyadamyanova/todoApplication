import java.io.Serializable;

public class TaskWithPriority extends Task implements Serializable {
    private PriorityLevel level;

    TaskWithPriority(String title, String description, PriorityLevel level) {
        super(title, description);
        this.level = level;
    }

    public String getLevel() {
        return switch (level) {
            case LOW -> "Low";
            case MEDIUM -> "Medium";
            case HIGH -> "High";
        };
    }

    public void setLevel(PriorityLevel level) {
        this.level = level;
    }

    @Override
    public void printTask(){
        System.out.println("Task " + this.get_id() + " :");
        System.out.println("Title - " + this.getTitle());
        System.out.println("Description - " + this.getDescription());
        System.out.println("Created date: " + this.getCreatedDate());
        if(this.isCompleted()) {
            System.out.println("Status : completed");
        }else{
            System.out.println("Status : uncompleted");
        }
        System.out.println("Priority: " + this.getLevel());
    }
}