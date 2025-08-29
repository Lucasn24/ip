package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;
import talkgpt.task.Task;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }


    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        String oldTask = list.get(index).serialize();
        Task newTask = list.markTask(index);
        ui.markTask(newTask, list.size());
        storage.update(oldTask, newTask);
    }
}
