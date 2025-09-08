package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class GoodbyeCommand extends Command {

    /**
     * Command to execute goodbye statement
     */
    public GoodbyeCommand(){
        super(true);
    }

    /**
     * Execute goodbye statement from UI
     *
     * @param list TaskList
     * @param ui UI to print goodbye statement
     * @param storage Storage
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) {
        return ui.goodbye();
    }
}
