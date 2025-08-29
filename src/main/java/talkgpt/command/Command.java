package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

abstract public class Command {
    private boolean isExit;

    public Command(boolean isExit){
        this.isExit = isExit;
    }

    public boolean isExit(){
        return this.isExit;
    }

    abstract public void execute(TaskList list, Ui ui, Storage storage);
}
