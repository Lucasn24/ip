package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task){
        super(false);
        this.task = task;
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addTask(task);
        ui.addTask(task, list.size());
        storage.save(task);
    }
}
