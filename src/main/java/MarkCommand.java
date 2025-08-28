public class MarkCommand extends Command{
    private int index;

    public MarkCommand(String index){
        this.index = Integer.parseInt(index) - 1;
    }


    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Task oldTask = list.get(index);
        Task newTask = list.markTask(index);
        ui.markTask(newTask, list.size());
        storage.update(oldTask, newTask);
    }
}
