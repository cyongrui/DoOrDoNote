import java.io.IOException;
import java.util.*;

public class main {
	
	
	public static void main(String[] args){
		Storage str = new Storage();
		Date date0 = new Date(2015, 10, 6, 13,27);
		Date date1 = null;
		Date date2 = new Date(2015, 10, 3);
		Task task = new Task("appendix", date0);
		Task task1 = new Task("fishing", date0);
		Task task2 = new Task("Do CS homework", date0);
		Task task3 = new Task("Swimming", date0);
		
	//	String returnStr = str.add("appendix", date0, date1);
	//	str.add("fishing", date0, date2);
	//	str.add("running", date0, date2);
		String str2 = str.update(0, "Do CS homework", date0, date1);
	//	str.delete(0);
	//	str.undo();
	//	str.redo();
		System.out.println(str2);
		try{
/*		ArrayList<Task> arrList = str.read();
		for(int i=0; i<arrList.size(); i++){
			System.out.println(arrList.get(i));
		}*/
		System.out.println(StorageBackEnd.getFileString("data.json"));
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
