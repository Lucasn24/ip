package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class MarkCommand extends Command {
    private int index;

    /**
     * Command to mark task
     *
     * @param index index of the task in the list to be marked
     */
    public MarkCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }

    /**
     * Execute the mark Task functions for the taskList, UI and Storage
     *
     * @param list TaskList for task to be marked
     * @param ui UI for the mark task print statement
     * @param storage Storage for the marked task to be updated
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        String oldTask = list.get(index).serialize();
        Task newTask = list.markTask(index);
        ui.markTask(newTask, list.size());
        storage.update(oldTask, newTask);
    }
}
