package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class UnmarkCommand extends Command {
    private int index;

    /**
     * Command to unmark task
     *
     * @param index index of the task in the list to be unmarked
     */
    public UnmarkCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }

    /**
     * Execute the unmark Task functions for the taskList, UI and Storage
     *
     * @param list TaskList for task to be unmarked
     * @param ui UI for the unmark task print statement
     * @param storage Storage for the unmarked task to be updated
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        String oldTask = list.get(index).serialize();
        Task newTask = list.unmarkTask(index);
        ui.unmarkTask(newTask, list.size());
        storage.update(oldTask, newTask);
    }
}
