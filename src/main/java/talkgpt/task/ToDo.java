package talkgpt.task;

import java.util.Objects;

public class ToDo extends Task {
    public ToDo(String task) {
        super(task, false);
    }

    public ToDo(String task, boolean done){
        super(task, done);
    }
    public static ToDo deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2];

        if (Objects.equals(completed, "true")) {
            return new ToDo(description, true);
        } else {
            return new ToDo(description, false);
        }
    }

    @Override
    public String serialize(){
        return String.format("T|%b|%s", super.getStatus(), super.getTask());
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
