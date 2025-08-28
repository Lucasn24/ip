public class DeleteCommand extends Command{
    private final int index;

    public DeleteCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }

    @Override
    void execute(TaskList list, Ui ui, Storage storage) {
        Task task = list.deleteTask(index);
        ui.deleteTask(task, list.size());
        storage.delete(task);
    }
}
