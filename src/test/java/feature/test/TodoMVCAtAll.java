package feature.test;

import feature.test.pages.TodoMVC;
import org.junit.Test;

import static feature.test.pages.TodoMVC.TaskType.ACTIVE;
import static feature.test.pages.TodoMVC.TaskType.COMPLETED;
import static feature.test.pages.TodoMVC.*;


/**
 * Created by barocko on 8/10/2016.
 */
public class TodoMVCAtAll extends BaseTest {

    @Test
    public void testEdit() {
        givenAtAll(ACTIVE, "1", "2");

        edit("1", "1 edited");

        assertTasksAre("1 edited", "2");
        assertItemsLeft(2);
    }

    @Test
    public void testDelete() {
        givenAtAll(COMPLETED, "1");

        delete("1");

        assertNoTasks();
    }

    @Test
    public void testCompleteAll() {
        givenAtAll(ACTIVE, "1", "2");

        toggleAll();

        assertTasksAre("1", "2");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompleted() {
        given(aTask(COMPLETED, "1"), aTask(ACTIVE, "2"));

        clearCompleted();

        assertTasksAre("2");
        assertItemsLeft(1);
    }

    @Test
    public void testSwitchFilterToCompleted() {
        given(aTask(COMPLETED, "1"), aTask(ACTIVE, "2"));

        filterCompleted();

        assertVisibleTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        givenAtAll(ACTIVE, "1");

        cancelEdit("1", "1 editing");

        assertTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testReopen() {
        givenAtAll(COMPLETED, "1");

        toggle("1");

        assertTasksAre("1");
        assertItemsLeft(1);
    }

    @Test
    public void testConfirmEditByPressTab() {
        givenAtAll(COMPLETED, "1");

        confirmEditByPressTab("1", "1 edited");

        assertTasksAre("1 edited");
        assertItemsLeft(0);
    }

}
