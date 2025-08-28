abstract public class Command {
    private boolean isExit;

    public Command(boolean isExit){
        this.isExit = isExit;
    }

    public boolean isExit(){
        return this.isExit;
    }

    abstract void execute(TaskList list, Ui ui, Storage storage);
}
