import java.io.IOException;

public class main {
	
	
	public static void main(String[] args){
		Storage str = new Storage();
		Task task = new Task("appendix", "13-3", "12:31", 0);
		Task task2 = new Task("fishing", "4-9", "21:03", 1);
		System.out.println(str.getFileName());
		
		str.write(task);
		str.write(task2);
		str.undo();
		str.redo();
		try{
//		str.read();
		System.out.println(Storage.getFileString("data.json"));
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
