package doordonote.storage;

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
	private static final String NAME_TESTWRITE = "{\"195\":{\"desc\":\"Do CS homework\",\"time\":\"00:00\",\"date\":\"6-11\",\"priority\":1},\"1320\":{\"desc\":\"Flying Pig\",\"time\":\"16:30\",\"date\":\"14-4\",\"priority\":0},\"3212\":{\"desc\":\"Swimming\",\"time\":\"21:01\",\"date\":\"12-3\",\"priority\":2},\"3730\":{\"desc\":\"Running\",\"time\":\"17:30\",\"date\":\"29-9\",\"priority\":0}}";

	Storage str = new Storage(NAME_TEST);
	
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
	
	@Test
	public void testCustomFileName(){
		Storage str = new Storage(NAME_CUSTOM);
		assertEquals(str.getFileName(), "custom.json");
	}
	
	@Test
	public void testStorageClear() throws IOException{
		addTaskToStorage();
		str.clear();
		assertEquals(Storage.getFileString(NAME_TEST), "");
	}
	
	@Test
	public void testStorageWrite() throws IOException{
		addTaskToStorage();
		assertEquals(Storage.getFileString(NAME_TEST), NAME_TESTWRITE);
	}
	
	@Test
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
		Task task0 = new Task("Flying Pig", date0, 0);
		Task task1 = new Task("Do CS homework", date0, 1);
		Task task2 = new Task("Swimming", date0, 2);
		Task task3 = new Task("Running", date0, 0);
		str.write(task0);
		str.write(task1);
		str.write(task2);
		str.write(task3);
	}
	

}
