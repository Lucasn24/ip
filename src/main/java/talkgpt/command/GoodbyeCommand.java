package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class GoodbyeCommand extends Command {

    public GoodbyeCommand(){
        super(true);
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ui.goodbye();
    }
}
