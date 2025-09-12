package talkgpt.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Objects;

public class Deadline extends Task {
    private final LocalDateTime dueDate;

    /**
     * Construct a deadline task, which is unmarked
     *
     * @param task description of the task
     * @param dueDate dueDate of the task in d/m/yyyy HHmm format
     */
    public Deadline(String task, String dueDate) {
        super(task, false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

        this.dueDate = LocalDateTime.parse(dueDate, formatter);

    }

    /**
     * Construct a deadline task, which is marked depending on the boolean done
     *
     * @param task description of the task
     * @param dueDate dueDate of the task in yyyy-mm-ddTHH:mm format
     * @param done status of completion
     */
    public Deadline(String task, String dueDate, boolean done) {
        super(task, done);
        this.dueDate = LocalDateTime.parse(dueDate);
    }

    /**
     * Reads the serialized string and constructs the corresponding Deadline task
     *
     * @param parts array of parsed string in [D, true, read book, 2025-12-03T18:00]
     * @return Deadline task
     */
    public static Deadline deserialize(String[] parts){
        assert Objects.equals(parts[0], "D") : "The serialized task is not a Deadline";
        assert parts.length == 4 : "The serialized Deadline task should have 4 components";
        
        String completed = parts[1];
        String description = parts[2];
        String due = parts[3];

        if (Objects.equals(completed, "true")) {
            return new Deadline(description, due,true);
        } else {
            return new Deadline(description, due,false);
        }
    }

    /**
     * Converts the Deadline Task into a serialized string
     *
     * @return a serialized string in E|true|deadline|2024-12-03T1800 format
     */
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
