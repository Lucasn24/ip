package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword){
        super(false);
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        TaskList tasks = list.findTask(keyword);
        ui.findTask(tasks);
    }
}
