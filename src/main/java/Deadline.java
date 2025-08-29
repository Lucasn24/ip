import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private final LocalDateTime dueDate;

    Deadline(String task, String dueDate) {
        super(task, false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

        this.dueDate = LocalDateTime.parse(dueDate, formatter);

    }

    Deadline(String task, String dueDate, boolean done) {
        super(task, done);
        this.dueDate = LocalDateTime.parse(dueDate);
    }

    public static Deadline deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2];
        String due = parts[3];

        System.out.println(due);
        if (Objects.equals(completed, "true")) {
            return new Deadline(description, due,true);
        } else {
            return new Deadline(description, due,false);
        }
    }

    @Override
    public String serialize(){
        //D|true|return book|03-12-2024T1800
        return String.format("D|%b|%s|%s", super.getStatus(), super.getTask(), this.dueDate);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (By "
                + this.dueDate.getDayOfWeek() + " "
                + this.dueDate.format(DateTimeFormatter.ofPattern("d MMM yyyy HHmm"))
                + ")";
    }
}
