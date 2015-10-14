import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class StorageTest {
	
	private static final String NAME_TEST = "test.json";
	private static final String NAME_CUSTOM = "custom";
	private static final String NAME_TESTWRITE = "{\"-147089846\":{\"type\":\"FloatingTask\",\"data\":{\"description\":\"Do CS homework\"}},\"770756571\":{\"type\":\"EventTask\",\"data\":{\"startDate\":\"Sep 7, 3915 2:13:00 AM\",\"endDate\":\"Nov 6, 3915 1:27:00 PM\",\"description\":\"Swimming\"}},\"123847613\":{\"type\":\"EventTask\",\"data\":{\"startDate\":\"Nov 6, 3915 1:27:00 PM\",\"endDate\":\"Sep 7, 3915 2:13:00 AM\",\"description\":\"Flying Pig\"}},\"678483322\":{\"type\":\"DeadlineTask\",\"data\":{\"endDate\":\"Nov 6, 3915 1:27:00 PM\",\"description\":\"Running\"}}}";

	JsonFileIO str = new JsonFileIO(NAME_TEST);
	
//	@Before
	public void setup(){
	}
	
	@After
	public void tearDown(){
		File test = new File(NAME_CUSTOM+".json");
		File file = new File(NAME_TEST);
		test.delete();
		file.delete();
	}
	
	@Test
	public void testDefaultFileName() {
		assertEquals(str.getFileName(), NAME_TEST);
	}
	
//	@Test
	public void testCustomFileName(){
		JsonFileIO str = new JsonFileIO(NAME_CUSTOM);
		assertEquals(str.getFileName(), "custom.json");
	}
	
//	@Test
	public void testStorageClear() throws IOException{
		addTaskToStorage();
		str.clear();
		assertEquals(JsonFileIO.getFileString(NAME_TEST), "");
	}
	
	@Test
	public void testStorageWrite() throws IOException{
		addTaskToStorage();
		assertEquals(NAME_TESTWRITE, JsonFileIO.getFileString(NAME_TEST));
	}
	
//	@Test
	public void testStorageRead() throws IOException{
		addTaskToStorage();
		String expected = "Description: Swimming. \nDescription: Running. \nDescription: Flying Pig. \nDescription: Do CS homework. \n";
		String actual = "";
		ArrayList<Task> arrList = str.read();
		for(int i=0; i<arrList.size(); i++){
			actual += arrList.get(i).toString();
			actual += "\n";
		}
		assertEquals(expected, actual);
	}
	
	private void addTaskToStorage(){
		Date date0 = new Date(2015, 10, 6, 13,27);
		Date date1 = new Date(2015, 8, 7, 2, 13);
		Task task0 = new EventTask("Flying Pig", date0, date1);
		Task task1 = new FloatingTask("Do CS homework");
		Task task2 = new EventTask("Swimming", date1, date0);
		Task task3 = new DeadlineTask("Running", date0);
		str.write(task0);
		str.write(task1);
		str.write(task2);
		str.write(task3);
	}
	

}
