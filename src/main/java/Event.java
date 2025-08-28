import java.util.Objects;

public class Event extends Task{
    private final String from;
    private final String to;

    Event(String task, String from, String to) {
        super(task, false);
        this.from = from;
        this.to = to;
    }

    Event(String task, String from, String to, boolean done) {
        super(task, done);
        this.from = from;
        this.to = to;
    }

    public static Event deserialize(String[] parts){
        String completed = parts[1];
        String description = parts[2] + " ";
        String from = " " + parts[3] + " ";
        String to = " " + parts[4];

        if (Objects.equals(completed, "true")) {
            return new Event(description, from, to, true);
        } else {
            return new Event(description, from, to, false);
        }
    }

    @Override
    public String serialize(){
        return String.format("E|%b|%s|%s|%s\n", super.getStatus(), super.getTask(), this.from, this.to);
    }

    @Override
    public String toString() {
        String duration = String.format("(from:%sto:%s)", this.from, this.to);
        return "[E]" + super.toString() + duration;
    }
}
