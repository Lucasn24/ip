import java.util.Objects;

public class Deadline extends Task{
    private final String dueDate;

    Deadline(String task, String dueDate) {
        super(task, false);
        this.dueDate = dueDate;
    }

    Deadline(String task, String dueDate, boolean done) {
        super(task, done);
        this.dueDate = dueDate;
    }

    public static Deadline deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2] + " ";
        String due = parts[3];

        if (Objects.equals(completed, "true")) {
            return new Deadline(description, due,true);
        } else {
            return new Deadline(description, due,false);
        }
    }

    @Override
    public String serialize(){
        return String.format("D|%b|%s|%s\n", super.getStatus(), super.getTask(), this.dueDate);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(" + this.dueDate + ")";
    }
}
