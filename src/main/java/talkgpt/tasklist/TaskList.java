package talkgpt.tasklist;

import talkgpt.task.Task;

import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {

    public TaskList(){}

    /**
     * marks the task of the given index
     * returns the marked task
     *
     * @param index of the task to be marked
     * @return marked task
     */
    public Task markTask(int index){
        Task task = super.get(index);
        task.mark();

        return task;
    }

    /**
     * unmarks the task of the given index
     * returns the unmarked task
     *
     * @param index of the task to be unmarked
     * @return unmarked task
     */
    public Task unmarkTask(int index){
        Task task = super.get(index);
        task.unmark();

        return task;
    }

    /**
     * delete the task of the given index from the tasklist
     * return the deleted task
     *
     * @param index of the task to be deleted
     * @return deleted task
     */
    public Task deleteTask(int index){
        Task task = super.get(index);
        super.remove(index);

        return task;
    }

    /**
     * add task into the tasklist
     *
     * @param task to be added
     */
    public void addTask(Task task){
        super.add(task);
    }

    @Override
    public String toString(){
        String header = "Here are the tasks in your list:\n";
        StringBuilder msg = new StringBuilder();

        for (int i = 0; i < super.size(); i++) {
            String adding = String.format("%d. %s\n", i+1, super.get(i).toString());
            msg.append(adding);
        }

        return header + msg;
    }
}
