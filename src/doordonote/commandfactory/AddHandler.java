package doordonote.commandfactory;

import java.util.Date;
import java.util.List;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import doordonote.command.AddCommand;
import doordonote.command.Command;

public class AddHandler extends AbstractAddCommandHandler {
	protected Parser dateParser = null;
	
	public AddHandler(String commandBody, Parser dateParser) {
		super(commandBody, dateParser);
	}

	
	// TODO: Write cleaner code, throw exception when handling null commandBody, stricter rules for parsing dates
	@Override
	public Command generateCommand() {
		int indexOfEventDate = commandBody.toLowerCase().lastIndexOf("from");
		int indexofDeadlineDate = commandBody.toLowerCase().lastIndexOf("by");
		List<DateGroup> dateList = null;

		// This case still needs to be refined
		if (indexOfEventDate > indexofDeadlineDate) { 	// add task is an event
			String taskDescription = commandBody.substring(0, indexOfEventDate);
			String eventPeriod = commandBody.substring(indexOfEventDate);
			dateList = dateParser.parse(eventPeriod);
			if (dateList.size() < 1) {					// add task is a floating task
				return new AddCommand(taskDescription, null, null);
			} else {
				// add task is an event
				List<Date> dates = dateList.get(0).getDates();
				Date startDate = dates.get(0);
				Date endDate = dates.get(1);
				return new AddCommand(taskDescription, startDate, endDate);
			}
		} else {
			String taskDescription = commandBody.substring(0, indexofDeadlineDate);
			String deadlinePeriod = commandBody.substring(indexofDeadlineDate);
			dateList = dateParser.parse(deadlinePeriod);
			if (dateList.isEmpty()) {					// add task is a floating task
				return new AddCommand(taskDescription, null, null);
			} else {
				// add task is a deadline
				List<Date> dates = dateList.get(0).getDates();
				Date endDate = dates.get(0);
				return new AddCommand(taskDescription, null, endDate);
			}
		}
		
		
		
	}
	
	
//	public static void main(String[] args) {
//		AddHandler addHandler = new AddHandler("do wok from monday to thurs", new Parser());
//		Command cmd = addHandler.generateCommand();
//		System.out.println("test");
//	}
	

}
