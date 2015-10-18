package doordonote.commandfactory;

import doordonote.command.Command;
import doordonote.command.DeleteCommand;

public class DeleteHandler extends AbstractCommandHandler {

	public DeleteHandler(String commmandBody) {
		super(commmandBody);
	}

	@Override
	public Command generateCommand() {
		try {
			int indexToDelete = Integer.parseInt(commandBody.trim());
			if (indexToDelete <= 0) {
				// throw exception
				return null;
			} else {
				return new DeleteCommand(indexToDelete);
			}
		} catch (NumberFormatException e) {
			// commandBody does is not a valid integer value
			// throw exception
			return null;
		}		
	}

}
