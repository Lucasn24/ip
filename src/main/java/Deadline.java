public class Deadline extends Task{
    private String dueDate;

    Deadline(String task, String dueDate) {
        super(task);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        String due = String.format("(by:%s)", this.dueDate);
        return "[D]" + super.toString() + due;
    }
}
