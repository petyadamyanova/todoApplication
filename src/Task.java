import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private static int id_count = 0;
    private final int id;
    private String title;
    private String description;
    private Date createdDate;
    private boolean completed;
    private static final long serialVersionUID = 7417348823076488010L;

    public Task(String title, String description) {
        this.id = ++id_count;
        this.title = title;
        this.description = description;
        this.createdDate = new Date();
        this.completed = false;
    }

    public static void setIdCount(int count) {
        id_count = count;
    }

    public static void setId_count(int id_count) {
        Task.id_count = id_count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int get_id() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void markAsIncomplete() {
        this.completed = false;
    }

    public void printTask(){
        System.out.println("Task " + this.id + " :");
        System.out.println("Title - " + this.title);
        System.out.println("Description - " + this.description);
        System.out.println("Created date: " + this.createdDate);
        if(this.completed) {
            System.out.println("Status : completed");
        }else{
            System.out.println("Status : uncompleted");
        }
    }
}
