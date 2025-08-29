package talkgpt.tasklist;

import org.junit.jupiter.api.Test;
import talkgpt.task.Task;
import talkgpt.task.ToDo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void testMarkTask(){
        TaskList taskList = new TaskList();
        Task task = new ToDo("read book");
        taskList.add(task);
        taskList.markTask(0);

        task.mark();
        assertEquals(task, taskList.get(0));
    }

    @Test
    public void testUnmarkTask(){
        TaskList taskList = new TaskList();
        Task task = new ToDo("read book", true);
        taskList.add(task);
        taskList.unmarkTask(0);

        task.unmark();
        assertEquals(task, taskList.get(0));
    }

    @Test
    public void testDeleteTask(){
        TaskList taskList = new TaskList();
        Task task1 = new ToDo("read book");
        Task task2 = new ToDo("return book");
        Task task3 = new ToDo("walk in the park");

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        taskList.deleteTask(1);

        TaskList expected = new TaskList();
        expected.add(task1);
        expected.add(task3);

        assertEquals(expected, taskList);
    }

    @Test
    public void testAddTask() {
        TaskList output = new TaskList();
        Task task = new ToDo("read book");
        output.addTask(task);

        assertEquals(1, output.size());
        assertEquals(task, output.get(0));
    }


}
