package talkgpt.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static talkgpt.task.Deadline.deserialize;

public class DeadlineTest {
    @Test
    public void testDeserialize() {
        String task = "D|false|return book|2025-12-03T18:00";
        Deadline expected = new Deadline("return book", "2025-12-03T18:00", false);
        assertEquals(expected,deserialize(task.split("\\s*\\|\\s*")));
    }

    @Test
    public void testSerialize() {
        Deadline task = new Deadline("return book", "2025-12-03T18:00", false);
        String expected = "D|false|return book|2025-12-03T18:00";
        assertEquals(expected, task.serialize());
    }

}
