public class UnmarkCommand extends Command{
    private int index;

    public UnmarkCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Task oldTask = list.get(index);
        Task newTask = list.unmarkTask(index);
        ui.markTask(newTask, list.size());
        storage.update(oldTask, newTask);
    }
}
