package doordonote.command;

import java.util.Date;

public class AddCommand extends RedoableCommand {
	protected String task = null;
	protected Date startDate = null;
	protected Date endDate = null;
	
	// Constructor for events
	public AddCommand(String task, Date startDate, Date endDate) {
		this(task, endDate);
		this.startDate = startDate;
	}
	
	// Constructor for deadlines
	public AddCommand(String task, Date endDate) {
		this(task);
		this.endDate = endDate;
	}
	
	// Constructor for floating tasks
	public AddCommand(String task) {
		this.task = task;
	}

	@Override
	public String run() {
		if (storageObj == null) {
			return "Error in storage object";
		} else {
			String returnMsg = null;
			returnMsg = storageObj.add(task, startDate, endDate);
			return returnMsg;		
		}
	}

}
