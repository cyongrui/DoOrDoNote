import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class StorageTest {
	
	private static final String DEFAULT_NAME = "data.json";
	private static final String TEST_NAME = "test";

	Storage str = new Storage();
	
//	@Before
	public void setup(){
	}
	
	@After
	public void tearDown(){
		File test = new File(TEST_NAME+".json");
		File file = new File(DEFAULT_NAME);
		test.delete();
		file.delete();
	}
	
	@Test
	public void testDefaultFileName() {
		assertEquals(str.getFileName(), DEFAULT_NAME);
	}
	
	@Test
	public void testCustomFileName(){
		Storage str = new Storage(TEST_NAME);
		assertEquals(str.getFileName(), "test.json");
	}
	
	@Test
	public void testStorageClear(){
	//	assertEquals(str.clear(), "")
	}
	

}
