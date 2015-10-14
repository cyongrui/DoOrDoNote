package doordonote.command;

import doordonote.storage.Storage;

public abstract class RedoableCommand implements Command {
	protected Storage storageObj = null;
	
	@Override
	public boolean isRedoable() {
		return true;
	}
	
	public boolean setStorage(Storage storageObj) {
		this.storageObj = storageObj;
		return true;
	}
	
	@Override
	public String run(Storage storageObj) {
		setStorage(storageObj);
		String returnMsg = run();
		return returnMsg;
	}
	
	public abstract String run();


}
