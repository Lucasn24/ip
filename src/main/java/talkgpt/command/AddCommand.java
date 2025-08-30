package talkgpt.command;

import talkgpt.storage.Storage;
import talkgpt.task.Task;
import talkgpt.tasklist.TaskList;
import talkgpt.ui.Ui;

public class AddCommand extends Command {
    private Task task;

    /**
     * Command to add task
     *
     * @param task Task to be added
     */
    public AddCommand(Task task){
        super(false);
        this.task = task;
    }

    /**
     * Execute the add Task functions for the taskList, UI and Storage
     *
     * @param list TaskList for task to be added into
     * @param ui UI for the add task print statement
     * @param storage Storage for the task to be saved in
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        list.addTask(task);
        ui.addTask(task, list.size());
        storage.save(task);
    }
}
