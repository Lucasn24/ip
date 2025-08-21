public class Event extends Task{
    private String from;
    private String to;

    Event(String task, String from, String to) {
        super(task);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        String duration = String.format("(from:%sto:%s)", this.from, this.to);
        return "[E]" + super.toString() + duration;
    }
}
