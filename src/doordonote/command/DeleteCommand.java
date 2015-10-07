package doordonote.command;

public class DeleteCommand extends RedoableCommand {
	int indexOfTaskToDelete = -1;
	
	public DeleteCommand(int indexOfTaskToDelete) {
		this.indexOfTaskToDelete = indexOfTaskToDelete;
	}
	
	@Override
	public String run() {
		if (storageObj != null) {
			return "Error in storage object";
		} else {
			return storageObj.delete(indexOfTaskToDelete);
		}
	}
}
