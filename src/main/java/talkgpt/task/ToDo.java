package talkgpt.task;

import java.util.Objects;

public class ToDo extends Task {
    /**
     * Constructs a ToDo task, which is unmarked
     * @param task description of the task
     */
    public ToDo(String task) {
        super(task, false);
    }

    /**
     * Construct a ToDo task. which is marked depending on the boolean done
     * @param task description of the task
     * @param done status of completion
     */
    public ToDo(String task, boolean done){
        super(task, done);
    }

    /**
     * Reads the serialized string and constructs the corresponding ToDo task
     * @param parts array of parsed string in [T, true, read book]
     * @return ToDo task
     */
    public static ToDo deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2];

        if (Objects.equals(completed, "true")) {
            return new ToDo(description, true);
        } else {
            return new ToDo(description, false);
        }
    }

    /**
     * Converts the ToDo Task into a serialized string
     * @return a serialized string
     */
    @Override
    public String serialize(){
        return String.format("T|%b|%s", super.getStatus(), super.getTask());
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
