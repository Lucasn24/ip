import java.util.Objects;

public class ToDo extends Task{
    ToDo(String task) {
        super(task, false);
    }

    ToDo(String task, boolean done){
        super(task, done);
    }
    public static ToDo deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2];

        if (Objects.equals(completed, "1")) {
            return new ToDo(description, true);
        } else {
            return new ToDo(description, false);
        }
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
