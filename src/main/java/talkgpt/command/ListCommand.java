package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class ListCommand extends Command {

    /**
     * Command to execute list statement
     */
    public ListCommand(){
        super(false);
    }

    /**
     * Execute goodbye statement from UI
     *
     * @param list TaskList
     * @param ui UI to print list statement
     * @param storage Storage
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        ui.listView(list);
    }
}
