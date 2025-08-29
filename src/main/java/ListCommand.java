public class ListCommand extends Command{

    public ListCommand(){
        super(false);
    }

    @Override
    void execute(TaskList list, Ui ui, Storage storage) {
        ui.listView(list);
    }
}
