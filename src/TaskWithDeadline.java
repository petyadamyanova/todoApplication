import java.util.Date;

public class TaskWithDeadline extends Task{
    private Date deadline;

    public TaskWithDeadline(String title, String description, Date deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return deadline.before(currentDate);
    }

    public void changeDeadLine(Date newDeadLine){
        Date currentDate = new Date();
        if(!newDeadLine.before(currentDate))
            this.deadline = newDeadLine;
    }
}
