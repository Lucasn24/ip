package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class ListCommand extends Command {

    public ListCommand(){
        super(false);
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ui.listView(list);
    }
}
