
public class main {
	
	
	public static void main(String[] args){
		Storage str = new Storage();
		DateStub date = new DateStub();
		TaskStub task = new TaskStub();
		System.out.println(str.getFileName());
		
		str.write(task);
		str.write(task);
		str.write(task, date);
		str.read();
	}
}
