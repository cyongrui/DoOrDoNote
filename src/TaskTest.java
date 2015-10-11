import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TaskTest {

	
	@Test
	public void testEqualsWithSameFloatingTask() {
		Task task1 = new Task("test");
		assertTrue(task1.equals(task1));
	}
	
	
	@Test
	public void testHashCodeWithSameFloatingTask() {
		Task task1 = new Task("test");
		Task task2 = new Task("test");
		assertTrue(task1.hashCode() == task2.hashCode());
	}
	
	
	@Test
	public void testEqualsWithSameDeadlineTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 1, 1, 1, 1);
		Task task1 = new Task("test", date1);
		Task task2 = new Task("test", date2);
		assertTrue(task1.equals(task2));
	}
	
	
	@Test
	public void testHashCodeWithSameDeadlineTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 1, 1, 1, 1);
		Task task1 = new Task("test", date1);
		Task task2 = new Task("test", date2);
		assertTrue(task1.hashCode() == task2.hashCode());
	}
	
	
	@Test
	public void testEqualsWithSameEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Task task1 = new Task("test", date1, date2);
		Task task2 = new Task("test", date1, date2);
		assertTrue(task1.equals(task2));
	}
	
	
	@Test
	public void testHashCodeWithSameEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Task task1 = new Task("test", date1, date2);
		Task task2 = new Task("test", date1, date2);
		assertTrue(task1.hashCode() == task2.hashCode());
	}
	
	@Test
	public void testEqualsWithDifferentEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Date date3 = new Date(2015, 1, 1, 1, 2);
		Task task1 = new Task("test", date1, date2);
		Task task2 = new Task("test", date1, date3);
		assertFalse(task1.equals(task2));
	}
	
	
	@Test
	public void testHashCodeWithDifferentEventTask() {
		Date date1 = new Date(2015, 1, 1, 1, 1);
		Date date2 = new Date(2015, 10, 3);
		Date date3 = new Date(2015, 1, 1, 1, 2);
		Task task1 = new Task("test", date1, date2);
		Task task2 = new Task("test", date1, date3);
		assertFalse(task1.hashCode() == task2.hashCode());
	}

}
