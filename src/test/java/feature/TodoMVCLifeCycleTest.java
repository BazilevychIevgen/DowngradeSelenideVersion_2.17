package feature;

import feature.pages.TodoMVC;
import org.junit.Test;

import static feature.pages.TodoMVC.*;


/**
 * Created by barocko on 7/25/2016.
 */
public class TodoMVCLifeCycleTest extends BaseTest {

    @Test
    public void testTaskLifeCycle() {
        given();

        add("1");
        toggle("1");
        assertTasksAre("1");

        filterActive();
        assertNoVisibleTasks();
        add("2");
        assertVisibleTasksAre("2");
        toggleAll();
        assertNoVisibleTasks();

        filterCompleted();
        assertVisibleTasksAre("1", "2");
        //reopen
        toggle("2");
        assertVisibleTasksAre("1");
        clearCompleted();
        assertNoVisibleTasks();

        filterAll();
        assertTasksAre("2");
        assertItemsLeft(1);
    }

}

