package doordonote.command;

import java.util.Date;

public class UpdateCommand extends RedoableCommand {

	protected int indexOfTaskToUpdate = -1;
	protected String task = null;
	protected Date startDate = null;
	protected Date endDate = null;
	
	// Constructor for events
	public UpdateCommand(int indexOfTaskToUpdate, String task, Date startDate, Date endDate) {
		this(indexOfTaskToUpdate, task, endDate);
		this.startDate = startDate;
	}
	
	// Constructor for deadlines
	public UpdateCommand(int indexOfTaskToUpdate, String task, Date endDate) {
		this(indexOfTaskToUpdate, task);
		this.endDate = endDate;
	}
	
	// Constructor for floating tasks
	public UpdateCommand(int indexOfTaskToUpdate, String task) {
		this.task = task;
		this.indexOfTaskToUpdate = indexOfTaskToUpdate;
	}
	
//	public UpdateCommand(int indexOfTaskToUpdate) {
//		this.indexOfTaskToUpdate = indexOfTaskToUpdate;
//	}

	public String run() {
		if (storageObj != null) {
			return "Error in storage object";
		} else {
			return storageObj.update(indexOfTaskToUpdate, task, startDate, endDate);
		}
	}
}
