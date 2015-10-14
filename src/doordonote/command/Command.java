package doordonote.command;

import doordonote.storage.Storage;

public interface Command {
	boolean isRedoable();
	String run();
	boolean setStorage(Storage storageObj);
	String run(Storage storageObj);
}
