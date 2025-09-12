package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

abstract public class Command {

    public Command() {}

    abstract public String execute(TaskList list, Ui ui, Storage storage);
}
