import java.util.Objects;

abstract public class Task {
    private final String task;
    private boolean done;

    Task(String task, boolean done){
        this.task = task;
        this.done = done;
    }

    public String getTask(){
        return this.task;
    }

    public boolean getStatus(){
        return this.done;
    }

    public void mark(){
        this.done = true;
    }

    public void unmark(){
        this.done = false;
    }

    public static Task deserialize(String input) throws TalkGPTException{
        String[] parts = input.split("\\s*\\|\\s*");
        String type = parts[0];

        switch(type){
            case "T" -> {
                return ToDo.deserialize(parts);
            }
            case "D" -> {
                return Deadline.deserialize(parts);
            }
            case "E" -> {
                return Event.deserialize(parts);
            }
            default -> throw new TalkGPTException("Invalid task type");
        }
    }

    abstract String serialize();

    @Override
    public String toString(){
        String checkbox = done ? "[X]" : "[ ]";
        return checkbox + " " + task;
    }

    @Override
    public boolean equals(Object o){
        if(Objects.equals(o.toString(), this.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
