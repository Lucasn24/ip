public class AddCommand extends Command{
    private Task task;

    public AddCommand(Task task){
        super(false);
        this.task = task;
    }

    @Override
    void execute(TaskList list, Ui ui, Storage storage) {
        list.addTask(task);
        ui.addTask(task, list.size());
        storage.save(task);
    }
}
