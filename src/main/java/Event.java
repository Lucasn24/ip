import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private final LocalDateTime from;
    private final LocalDateTime to;

    Event(String task, String from, String to) {
        super(task, false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    Event(String task, String from, String to, boolean done) {
        super(task, done);
        this.from = LocalDateTime.parse(from);
        this.to = LocalDateTime.parse(to);
    }

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
