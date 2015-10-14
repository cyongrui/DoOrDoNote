import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TaskTest {

	
	@Test
	public void testSameFloatingTask() {
		Task task1 = new FloatingTask("test");
		Task task2 = new FloatingTask("test");
		assertTrue(task1.hashCode() == task2.hashCode());
		assertTrue(task1.equals(task2));
	}
	
	
	
	@Test
	public void testSameDeadlineTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 1, 1, 1, 1);
		Task task1 = new DeadlineTask("test", date1);
		Task task2 = new DeadlineTask("test", date2);
		assertTrue(task1.hashCode() == task2.hashCode());
		assertTrue(task1.equals(task2));
	}
	
	
	@Test
	public void testSameEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Task task1 = new EventTask("test", date1, date2);
		Task task2 = new EventTask("test", date1, date2);
		assertTrue(task1.hashCode() == task2.hashCode());
		assertTrue(task1.equals(task2));
	}
	
	
	
	@Test
	public void testDifferentEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Date date3 = new Date(2015, 1, 1, 1, 2);
		Task task1 = new EventTask("test", date1, date2);
		Task task2 = new EventTask("test", date1, date3);
		assertFalse(task1.hashCode() == task2.hashCode());
		assertFalse(task1.equals(task2));
	}
	
	@Test
	public void testDifferentTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date3 = new Date(2015, 1, 1, 1, 2);
		Task task1 = new DeadlineTask("test", date1);
		Task task2 = new EventTask("test", date1, date3);
		assertFalse(task1.hashCode() == task2.hashCode());
		assertFalse(task1.equals(task2));
	}

}
