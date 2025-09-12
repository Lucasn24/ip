package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class ListCommand extends Command {

    /**
     * Command to execute list statement
     */
    public ListCommand() {}

    /**
     * Execute goodbye statement from UI
     *
     * @param list TaskList
     * @param ui UI to print list statement
     * @param storage Storage
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        return ui.listView(list);
    }
}
