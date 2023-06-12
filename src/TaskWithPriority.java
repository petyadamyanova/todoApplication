public class TaskWithPriority extends Task{
    private PriorityLevel level;

    private TaskWithPriority(String title, String description, PriorityLevel level) {
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
}