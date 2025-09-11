package talkgpt.task;

import java.util.Objects;

/**
 * Represents a ToDo task in the TalkGPT application.
 * A ToDo has only a description and a completion status.
 */
public class ToDo extends Task {
    /**
     * Constructs a ToDo task, which is unmarked by default.
     *
     * @param task Description of the task.
     */
    public ToDo(String task) {
        super(task, false);
    }

    /**
     * Constructs a ToDo task, which is marked depending on the boolean done.
     *
     * @param task Description of the task.
     * @param done Status of completion.
     */
    public ToDo(String task, boolean done) {
        super(task, done);
    }

    /**
     * Reads the serialized string and constructs the corresponding ToDo task.
     *
     * @param parts Array of parsed string in [T, true, read book].
     * @return ToDo task.
     */
    public static ToDo deserialize(String[] parts) {
        assert Objects.equals(parts[0], "T") : "The serialized task is not a ToDo";
        assert parts.length == 3 : "The serialized ToDo task should have 3 components";
        String completed = parts[1];
        String description = parts[2];

        if (Objects.equals(completed, "true")) {
            return new ToDo(description, true);
        } else {
            return new ToDo(description, false);
        }
    }

    /**
     * Converts the ToDo Task into a serialized string.
     *
     * @return A serialized string.
     */
    @Override
    public String serialize() {
        return String.format("T|%b|%s", super.getStatus(), super.getTask());
    }

    /**
     * Returns the string representation of the ToDo task,
     * including its type and status.
     *
     * @return The string representation of the ToDo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
