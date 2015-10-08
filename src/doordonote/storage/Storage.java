package doordonote.storage;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
		Task task = null;
		if (startDate != null) {
			task = new Task(description, startDate, endDate);
		} else if (endDate != null) {
			task = new Task(description, endDate);
		} else {
			task = new Task(description);
		}
		storageBackEnd.write(task);
		return String.format(MESSAGE_ADD, task);
	}


	public String update(int indexOfTaskToUpdate, String description, Date startDate, Date endDate) {
		Task updatedTask = null;
		if (startDate != null) {
			updatedTask = new Task(description, startDate, endDate);
		} else if (endDate != null) {
			updatedTask = new Task(description, endDate);
		} else {
			updatedTask = new Task(description);
		}
		storageBackEnd.update(indexOfTaskToUpdate, updatedTask);
		return String.format(MESSAGE_UPDATE, updatedTask);
	}
	
	public String delete(int indexOfTaskToDelete){
		storageBackEnd.delete(indexOfTaskToDelete);
		return MESSAGE_DELETE;
	}

	public List<Task> read() throws IOException {
		return storageBackEnd.read();
	}
}
