import java.util.Date;

public class Storage implements StorageInterface {

	private final String MESSAGE_ADD = "Task %1$s added";
	private final String MESSAGE_UPDATE = "Task updated to %1$s";
	private final String MESSAGE_DELETE = "Task deleted";
	
	protected StorageBackEnd storageBackEnd;
	
	public Storage(){
		storageBackEnd = new StorageBackEnd();
	}
	
	public Storage(String fileName){
		storageBackEnd = new StorageBackEnd(fileName);
	}

	public String add(String description, Date startDate, Date endDate) {
		Task task = new Task(description, startDate, endDate);
		storageBackEnd.write(task);
		return String.format(MESSAGE_ADD, task);
	}


	public String update(int indexOfTaskToUpdate, String description, Date startDate, Date endDate) {
		Task updatedTask = new Task(description, startDate, endDate);
		storageBackEnd.update(indexOfTaskToUpdate, updatedTask);
		return String.format(MESSAGE_UPDATE, updatedTask);
	}
	
	public String delete(int indexOfTaskToDelete){
		storageBackEnd.delete(indexOfTaskToDelete);
		return MESSAGE_DELETE;
	}
}
