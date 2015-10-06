package doordonote.ui;

import java.io.*;
import java.util.*;
/*
 * 
 *  @author: Gupta Priyanka
 *  Only a basic CLI version, 
 *  needs to be improved in terms of design alot
 *  MESSAGE_PATH and handlePathCommand need completion
 *  displays dummy responses for the handle..() methods and displayTasks()
 *  needs to be improved to read from logic
 *  displayHelpCommand() method needs to be done
 *
 */

public class UI {

    // ================================================================
    // Message prompts
    // ================================================================

    private static final String MESSAGE_INVALID_COMMAND = "Invalid command.";
    private static final String MESSAGE_WELCOME = "Welcome to Do Or Do Note!";
    private static final String MESSAGE_COMMAND_PROMPT = "Command: ";
    private static final String MESSAGE_EXIT = "Goodbye!";
    private static final String MESSAGE_ADD = "Added task \"%1$s\"";
    private static final String MESSAGE_DELETE = "Deleted task \"%1$s\"";
    private static final String MESSAGE_UPDATE = "Updated task \"%1$s\" to \"%2$s\"";
    private static final String MESSAGE_UNDO = "Undo";
    private static final String MESSAGE_REDO = "Redo";
    private static final String MESSAGE_RESTORE = "Restored task \"%1$s\"";
    private static final String MESSAGE_FINISH = "Finished task \"%1$s\"";
    private static final String MESSAGE_PATH = "";
    private static final String MESSAGE_RENAME = "Renamed file \"%1$s\" to \"%2$s\"";
    private static final String MESSAGE_GET = "Using file \"%1%s\"";

    // ================================================================
    // Summary view table headers
    // ================================================================

    private static final String TASK_LIST_HEADER = "Tasks List\n";
    private static final String TASK_LIST_DIVIDER =
        "---------------------------------------------------------------------------\n";

    // ================================================================
    // Other constants
    // ================================================================

    private static boolean isTimeToExit = false;

    
     /**
     * The main method that is executed when this class is called.
     * 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Logic logic = new Logic();

        System.out.println(MESSAGE_WELCOME);
        displayTasks(logic);

        while (!isTimeToExit) {
            System.out.print(MESSAGE_COMMAND_PROMPT);
            String userInput = input.nextLine();
            System.out.println();
            System.out.println(handleUserInput(logic, userInput));
        }

        input.close();
    }


    public static String handleUserInput(Logic logic, String userInput) {
        switch (logic.executeCommand(userInput)) {
            case ADD :
                return handleAddCommand(logic);
                break;
            case DELETE :
                return handleDeleteCommand(logic);
                break;
            case UPDATE :
                return handleUpdateCommand(logic);
                break;
            case HELP :
                return handleHelpCommand();
                break;
            case UNDO:
                return handleUndoCommand(logic);
                break;
            case REDO:
                return handleRedoCommand(logic);
                break;
            case FIND:
                return handleFindCommand(logic);
                break;
            case RESTORE:
                return handleRestoreCommand(logic);
                break;
            case FINISH:
                return handleFinishCommand(logic);
                break;
            case PATH:
                return handlePathCommand();
                break;
            case RENAME:
                return handleRenameCommand(logic);
                break;
            case GET:
                return handleGetCommand(logic);
                break;
            case EXIT :
                isTimeToExit = true;
                return MESSAGE_EXIT;
                break;
            case INVALID :
            default :
                return handleInvalidCommand();
        }
    }


    private static String handleAddCommand(Logic logic) {
        displayTasks(logic);
        return String.format(MESSAGE_ADD, "task");
    }


    private static String handleDeleteCommand(Logic logic) {
    	displayTasks(logic);
    	return String.format(MESSAGE_DELETE, "task");
    }


    private static String handleUpdateCommand(Logic logic) {
    	displayTasks(logic);
    	return String.format(MESSAGE_DELETE, "task1", "task2");
    }


    private static String handleHelpCommand() {
    	displayHelpCommands();
    	return null;
    }


    private static String handleUndoCommand(Logic logic) {
    	displayTasks(logic);
    	return MESSAGE_UNDO;
    }


    private static String handleRedoCommand(Logic logic) {
    	displayTasks(logic);
    	return MESSAGE_REDO;
    }


    private static String handleFindCommand(Logic logic) {
    	return "task";
    }


    private static String handleRestoreCommand(Logic logic) {
    	displayTasks(logic);
    	return String.format(MESSAGE_RESTORE, "task");
    }


    private static String handleFinishCommand(Logic logic) {
    	displayTasks(logic);
    	return String.format(MESSAGE_FINISH, "task");
    }


    private static String handlePathCommand() {
    	return MESSAGE_PATH;
    }


    private static String handleRenameCommand() {
    	return String.format(MESSAGE_RENAME, "filename1", "filename2");
    }


    private static String handleGetCommand() {
    	return String.format(MESSAGE_GET, "filename");
    }


    private static String handleInvalidCommand() {
        return MESSAGE_INVALID_COMMAND;
    }


    private void displayTasks() {

    	System.out.print(TASK_LIST_HEADER);
    	System.out.print(TASK_LIST_DIVIDER);
        
    	// dummy display
    	for(int i = 1; i <= 4; i++) {
    		System.out.printf(i + ". Task" + i);
    	}

    	System.out.print(TASK_LIST_DIVIDER);
    }
    
    private void displayHelpCommands(){
    	
    	//to be done
    	
    }

}
