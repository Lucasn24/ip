package talkgpt.task;

import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    /**
     * Construct an Event task, which is unmarked
     * @param task description of the task
     * @param from start datetime of the task in d/m/yyyy HHmm format
     * @param to end datetime of the task in d/m/yyyy HHmm format
     */
    public Event(String task, String from, String to) {
        super(task, false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    /**
     * Construct an Event task, which is marked depending on the boolean done
     * @param task description of the task
     * @param from start datetime of the task in yyyy-mm-ddTHH:mm format
     * @param to end datetime of the task in yyyy-mm-ddTHH:mm format
     * @param done status of completion
     */
    public Event(String task, String from, String to, boolean done) {
        super(task, done);
        this.from = LocalDateTime.parse(from);
        this.to = LocalDateTime.parse(to);
    }

    /**
     * Reads the serialized string and constructs the corresponding Event task
     * @param parts array of parsed string in [E, true, read book, 2025-12-03T18:00, 2025-12-03T20:00]
     * @return Event task
     */
    public static Event deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2];
        String from = parts[3];
        String to = parts[4];

        if (Objects.equals(completed, "true")) {
            return new Event(description, from, to, true);
        } else {
            return new Event(description, from, to, false);
        }
    }

    /**
     * Converts the Event Task into a serialized string
     * @return a serialized string in E|true|event|2024-12-03T1800|2024-12-03T2000 format
     */
    @Override
    public String serialize(){
        //E|true|event|03-12-2024T1800|03-12-2024T2000
        return String.format("E|%b|%s|%s|%s", super.getStatus(), super.getTask(), this.from, this.to);
    }

    @Override
    public String toString() {
        String fromMsg = this.from.getDayOfWeek()
                + " " + this.from.format(DateTimeFormatter.ofPattern("d MMM yyyy HHmm"));
        String toMsg = this.from.format(DateTimeFormatter.ofPattern("d MMM yyyy HHmm"));

        return "[E]" + super.toString() + " (from: "
                + fromMsg + " to: " + toMsg + ")";
    }
}
