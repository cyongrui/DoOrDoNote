package doordonote.ui;

import doordonote.logic.Logic;
import doordonote.storage.Task;

import java.io.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

/*
 * 
 *  @author: Gupta Priyanka
 *  Only a basic CLI version, 
 *  needs to be improved in terms of design alot
 *
 *
 */

public class UI {

    private static final String MESSAGE_WELCOME = "Welcome to Collate!";
    private static final String MESSAGE_COMMAND_PROMPT = "Command: ";
    private static final String MESSAGE_EXIT = "Goodbye!";

    private static final String WELCOME_MESSAGE_DIVIDER =
        "---------------------------------------------------------------------------\n";
    
    private static final String TASK_LIST_HEADER = "Ongoing Tasks\n";
    private static final String TASK_LIST_DIVIDER =
        "-----------------------------------------------------\n";

    private static final String EVENTS_HEADER = "Events:\n";
    private static final String DEADLINES_HEADER = "Deadlines: \n";
    private static final String FLOATING_TASK_HEADER = "Floating Tasks: \n";

    private Scanner scanner = new Scanner(System.in);
	private Logic logic = new Logic();

	public String getUserInput() {

		System.out.print(MESSAGE_COMMAND_PROMPT);
		String command = scanner.nextLine();
		return command;

	}

	public void executeUserInput(String command) {

		String output = logic.parseAndExecuteCommand(command);
		if (output != null) {
			showFeedback(output);
			displayTasks();			
		}

	}
    
    public void displayTasks() {
    	List<Task> taskList = logic.getTasks();
    	SimpleDateFormat ft = new SimpleDateFormat ("EEE, MMM d, hh:mm");
        boolean haveEvents = false;
        boolean haveDeadlines = false;
        boolean haveFloatingTasks = false;

    	System.out.print(TASK_LIST_HEADER);
    	System.out.print(TASK_LIST_DIVIDER);
        
        int count = 1;

//        System.out.print(EVENTS_HEADER);
//        for(int i=0; i<taskList.size(); i++) {
//        	if(taskList.get(i).getTaskType() == 2) {
//        		haveEvents = true;
//        		System.out.println(count++ + ". " + taskList.get(i).getDesc() + " from " + ft.format(taskList.get(i).getTaskStartDate()) + " to " + ft.format(taskList.get(i).getTaskEndDate()));
//        	}
//        }
//
//        if(haveEvents == false) {
//        	System.out.println("*None*");
//        }
//        
//        System.out.print(DEADLINES_HEADER);
//        for(int j=0; j<taskList.size(); j++) {
//        	if(taskList.get(j).getTaskType() == 1) {
//        		haveDeadlines = true;
//        		System.out.println(count++ + ". " + taskList.get(j).getDesc() + " by " + ft.format(taskList.get(j).getTaskEndDate()));
//        	}
//        }
//
//        if(haveDeadlines == false) {
//        	System.out.println("*None*");
//        }
//
//        System.out.print(FLOATING_TASK_HEADER);
//        for(int k=0; k<taskList.size(); k++) {
//        	if(taskList.get(k).getTaskType() == 0) {
//        		haveFloatingTasks = true;
//        		System.out.println(count++ + ". " + taskList.get(k).getDesc());
//        	}
//        }
        
        for (int i = 0; i < taskList.size(); i++) {
        	if(taskList.get(i).getTaskType() == 0) {
        		haveFloatingTasks = true;
        		System.out.println(count++ + ". " + taskList.get(i).getDesc());
        	} else if (taskList.get(i).getTaskType() == 1) {
        		haveDeadlines = true;
        		System.out.println(count++ + ". " + taskList.get(i).getDesc() + " by " + ft.format(taskList.get(i).getTaskEndDate()));
        	} else {
        		haveEvents = true;
        		System.out.println(count++ + ". " + taskList.get(i).getDesc() + " from " + ft.format(taskList.get(i).getTaskStartDate()) + " to " + ft.format(taskList.get(i).getTaskEndDate()));
        	}
			
		}

//        if(haveDeadlines == false) {
//        	System.out.println("*None*");
//        }

    }

    public void showFeedback(String output) {
    	System.out.println(output);
    }

	public static void main(String[] args) {

		UI ui = new UI();
		
		System.out.println(MESSAGE_WELCOME);
		ui.displayTasks();			

		while (true) {
			String command = ui.getUserInput();
			ui.executeUserInput(command);
		}
	}
}
