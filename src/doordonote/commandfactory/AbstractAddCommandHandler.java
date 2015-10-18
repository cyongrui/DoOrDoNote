package doordonote.commandfactory;

import com.joestelmach.natty.Parser;

// TODO: Change name to make it more understandable
public abstract class AbstractAddCommandHandler extends AbstractCommandHandler {
	protected Parser dateParser = null;
	
	public AbstractAddCommandHandler(String commandBody, Parser dateParser) {
		super(commandBody);
		this.dateParser = dateParser;
	}
	
	public 

}
