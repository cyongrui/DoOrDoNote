import java.io.IOException;
import java.util.*;

public class main {
	
	
	public static void main(String[] args){
		TaskFileIO str = TaskFileIO.getInstance();
		Date date0 = new Date(2015, 10, 6, 13,27);
		Date date1 = null;
		Date date2 = new Date(2015, 10, 3);
		Task task = new DeadlineTask("appendix", date0);
		Task task1 = new DeadlineTask("fishing", date0);
		Task task2 = new DeadlineTask("Do CS homework", date0);
		Task task3 = new DeadlineTask("Swimming", date0);
		
	//	String str1 = str.add("appendix", date0, date2);
		//str.add("fishing", date0, date2);
	//	str.add("running", date0, date2);
	//	str.add("hello", date1, date2);
	//	String str2 = str.update(0, "Do CS homework", date1, date0);
	//	str.delete(0);
	//	System.out.println(str1);
		try{
/*		ArrayList<Task> arrList = str.read();
		for(int i=0; i<arrList.size(); i++){
			System.out.println(arrList.get(i));
		}*/
		System.out.println(JsonFileIO.getFileString("data.json"));
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
