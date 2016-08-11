package feature;

import feature.pages.TodoMVC;
import org.junit.Test;

import static feature.pages.TodoMVC.*;


/**
 * Created by barocko on 8/10/2016.
 */
public class TodoMVCAtCompletedTest extends BaseTest {

    @Test
    public void testEdit() {
        givenAtCompleted(aTask(TaskType.COMPLETED, "1"), aTask(TaskType.ACTIVE, "2"));

        edit("1", "1 edited");

        assertVisibleTasksAre("1 edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDelete() {
        givenAtCompleted(aTask(TaskType.COMPLETED, "1"), aTask(TaskType.ACTIVE, "2"));

        delete("1");

        assertNoVisibleTasks();
        assertItemsLeft(1);
    }

    @Test
    public void testSwitchToActiveFilter() {
        givenAtCompleted(aTask(TaskType.COMPLETED, "1"), aTask(TaskType.ACTIVE, "2"));

        filterActive();

        assertVisibleTasksAre("2");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        givenAtCompleted(aTask(TaskType.ACTIVE, "1"), aTask(TaskType.COMPLETED, "2"));

        cancelEdit("2", "to be canceled");

        assertVisibleTasksAre("2");
        assertItemsLeft(1);
    }

    @Test
    public void testConfirmEditByClickOutside() {
        givenAtCompleted(aTask(TaskType.COMPLETED, "1"), aTask(TaskType.ACTIVE, "2"));

        confirmEditByClickOutside("1", "1 edited");

        assertVisibleTasksAre("1 edited");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAll() {
        givenAtCompleted(TaskType.COMPLETED, "1", "2");

        toggleAll();

        assertNoVisibleTasks();
        assertItemsLeft(2);
    }

}
