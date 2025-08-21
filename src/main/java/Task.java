public class Task {
    private String task;
    private boolean done = false;

    Task(String task){
        this.task = task;
    }

    public void mark(){
        this.done = true;
    }

    public void unmark(){
        this.done = false;
    }

    @Override
    public String toString(){
        String checkbox = done ? "[X]" : "[ ]";
        return checkbox + " " + task;
    }
}
