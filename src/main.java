
public class main {
	
	
	public static void main(String[] args){
		Storage str = new Storage();
		DateStub date = new DateStub();
		TaskStub task = new TaskStub();
		TaskStub task1 = new TaskStub(1);
		System.out.println(str.getFileName());
		
		str.write(task);
		str.write(task1);
		str.write(task, date);
		str.read();
		
	}
}
