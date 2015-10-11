import java.util.Date;

public class TaskStorage implements Storage {

	private final String MESSAGE_ADD = "Task %1$s added";
	private final String MESSAGE_UPDATE = "Task updated to %1$s";
	private final String MESSAGE_DELETE = "Task deleted";
	
	protected StorageBackEnd storageBackEnd;
	private static TaskStorage taskStorage;
	
	private TaskStorage(){
		storageBackEnd = new StorageBackEnd();
	}
	
	private TaskStorage(String fileName){
		storageBackEnd = new StorageBackEnd(fileName);
	}
	
	public static TaskStorage getInstance(){
		if(taskStorage == null){
			taskStorage = new TaskStorage();
		}
		return taskStorage;
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
