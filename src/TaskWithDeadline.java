import java.time.LocalDate;
import java.util.Date;

public class TaskWithDeadline extends Task{
    private LocalDate deadline;

    public TaskWithDeadline(String title, String description, LocalDate deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return deadline.isBefore(currentDate);
    }

    public void changeDeadLine(LocalDate newDeadLine){
        LocalDate currentDate = LocalDate.now();
        if(!newDeadLine.isBefore(currentDate))
            this.deadline = newDeadLine;
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
        System.out.println("Deadline: " + this.deadline);
    }
}
