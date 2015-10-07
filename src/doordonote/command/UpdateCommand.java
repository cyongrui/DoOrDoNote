package doordonote.command;

public class UpdateCommand extends RedoableCommand {

	int indexOfTaskToUpdate = -1;
	
	public UpdateCommand(int indexOfTaskToUpdate) {
		this.indexOfTaskToUpdate = indexOfTaskToUpdate;
	}

	public String run() {
		if (storageObj != null) {
			return "Error in storage object";
		} else {
			return storageObj.update(indexOfTaskToUpdate);
		}
	}
}
