package doordonote.command;

public abstract class NonRedoableCommand implements Command {

	@Override
	public boolean isRedoable() {
		return false;
	}

}
