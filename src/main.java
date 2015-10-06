import java.io.IOException;
import java.util.*;

public class main {
	
	
	public static void main(String[] args){
		Storage str = new Storage();
		Date date0 = new Date(2015, 10, 6, 13,27);
		Task task = new Task("appendix", date0, 0);
		Task task1 = new Task("fishing", date0, 1);
		Task task2 = new Task("Do CS homework", date0, 1);
		Task task3 = new Task("Swimming", date0, 2);
		
	//	str.write(task);
	//	str.write(task2);
		str.update(task3, 1);
	//	str.delete(0);
	//	str.undo();
	//	str.redo();
		try{
/*		ArrayList<Task> arrList = str.read();
		for(int i=0; i<arrList.size(); i++){
			System.out.println(arrList.get(i));
		}*/
		System.out.println(Storage.getFileString("data.json"));
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
