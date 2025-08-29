public class GoodbyeCommand extends Command {

    public GoodbyeCommand(){
        super(true);
    }

    @Override
    void execute(TaskList list, Ui ui, Storage storage) {
        ui.goodbye();
    }
}
