package feature.test;

import feature.test.pages.TodoMVC;
import feature.test.pages.TodoMVC;
import org.junit.Test;

import static feature.test.pages.TodoMVC.TaskType.ACTIVE;
import static feature.test.pages.TodoMVC.TaskType.COMPLETED;
import static feature.test.pages.TodoMVC.*;


/**
 * Created by barocko on 8/10/2016.
 */
public class TodoMVCAtActive extends BaseTest {

    @Test
    public void testEdit() {
        TodoMVC.givenAtActive(aTask(COMPLETED, "1"), aTask(ACTIVE, "2"));

        edit("2", "2 edited");

        assertVisibleTasksAre("2 edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDelete() {
        givenAtActive(ACTIVE, "1", "2");

        delete("2");

        assertTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testSwitchFilterToAll() {
        givenAtActive(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        filterAll();

        assertTasksAre("1", "2");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteByEmptyingText() {
        givenAtActive(ACTIVE, "1", "2");

        edit("2", "");

        assertTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testClearCompleted() {
        givenAtActive(aTask(ACTIVE, "1"), aTask(COMPLETED, "2"));

        clearCompleted();

        assertTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        givenAtActive(ACTIVE, "1", "2");

        cancelEdit("2", "2 edited");

        assertTasksAre("1", "2");
        assertItemsLeft(2);
    }

    @Test
    public void testComplete() {
        givenAtActive(ACTIVE, "1", "2");

        toggle("2");

        assertVisibleTasksAre("1");
        assertItemsLeft(1);
    }

}
