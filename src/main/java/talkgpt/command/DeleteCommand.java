package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class DeleteCommand extends Command {
    private final int index;

    /**
     * Command to deleted task
     *
     * @param index index of the task in the list to be deleted
     */
    public DeleteCommand(String index){
        super(false);
        this.index = Integer.parseInt(index) - 1;
    }

    /**
     * Execute the delete Task functions for the taskList, UI and Storage
     *
     * @param list TaskList for task to be deleted into
     * @param ui UI for the deleted task print statement
     * @param storage Storage for the task to be deleted
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        Task task = list.deleteTask(index);
        ui.deleteTask(task, list.size());
        storage.delete(index);
    }
}
