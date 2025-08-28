public class ListCommand extends Command{

    public ListCommand(){}

    @Override
    void execute(TaskList list, Ui ui, Storage storage) {
        ui.listView(list);
    }
}
