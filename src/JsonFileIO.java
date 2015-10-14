import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/*
 * 
 *  @author: Chen Yongrui
 *  Still need to resolve hash collision??
 *  Undo/redo needs work and will not work for update
 *  Need more testing
 *  set method might need checking
 *  
 */


public class JsonFileIO {

	private static final String DEFAULT_NAME = "data.json";
	private static final String FILE_TYPE = ".json";
	private static final int HASH_SIZE = 4099;

	private final Gson gson = new GsonBuilder().registerTypeAdapter(Task.class, 
			new TaskClassAdapter<Task>()).create();

	private final Type type = new TypeToken<Map<Integer, Task>>(){}.getType();
	private Map<Integer, Task> map = new HashMap<>(HASH_SIZE);
	private final Stack<String> undo = new Stack<String>();
	private final Stack<String> redo = new Stack<String>();
	private ArrayList<Task> listTask;
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	//	private Set<Integer> keys;



	private static String currentFile;


	/************** Constructors **********************/

	public JsonFileIO(){
		currentFile = DEFAULT_NAME;
		initialize();
	}

	public JsonFileIO(String name){
		if(!name.contains(FILE_TYPE)){
			name += FILE_TYPE;
		}
		currentFile = name;
		initialize();
	}

	/**************** Accessors ***********************/

	public String getFileName() {
		return currentFile;
	}
	
	public ArrayList<Integer> getTaskId(){
		return keys;
	}


	/**************** Methods ***********************/


	public void setFile(String fileName){
		currentFile = fileName;
	}

	private void initialize(){
		try {
			File file = new File(currentFile);
			if(!file.exists()){
				file.createNewFile();
//				undo.push("");
			}			
			else{
				map = jsonToMap();
				for (Integer key: map.keySet()){
					keys.add(key);
				}
				listTask = read();
	//			undo.push(getFileString(currentFile));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void write(Task task){

		Integer taskKey = task.hashCode();
		map.put(taskKey, task);
		keys.add(taskKey);
		String json = gson.toJson(map, type);
		try{
			writeToFile(json);
		}

		catch(IOException e){
			e.printStackTrace();
		}
//		undo.push(json);
	}


	public void clear(){
		try{
			FileWriter fw = new FileWriter(currentFile);
			fw.close();
			undo.push("");
		}

		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void delete(Task taskToDelete) throws EmptyTaskListException{

		if(!map.isEmpty()){
			map.remove(taskToDelete.hashCode());
			String json = gson.toJson(map, type);
			try{
				writeToFile(json);
			}

			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		else{
			throw  new EmptyTaskListException();
		}

	}
	
	public void update(Task taskToUpdate, Task newUpdatedTask) 
			throws EmptyTaskListException{
		try{
		delete(taskToUpdate);
		write(newUpdatedTask);
		}
		catch(EmptyTaskListException e){
			throw e;
		}
	}

	//This method reads the current json file and returns an
	//arraylist of Task
	public ArrayList<Task> read() throws IOException{
		Task[] arrTask;
		Map<Integer, Task> jsonMap = jsonToMap();
		arrTask = jsonMap.values().toArray(new Task[jsonMap.size()]);
		listTask = new ArrayList<Task>(Arrays.asList(arrTask));
		return listTask;
	}


	public boolean undo() {
		if(!undo.isEmpty()){
			redo.push(undo.pop());
			if(!undo.isEmpty()){
				try{
					writeToFile(undo.peek());
				}
				catch (IOException e){
					e.printStackTrace();
				}
				return true;
			}
		}

		return false;
	}


	public boolean redo(){
		if(!redo.isEmpty()){
			try{
				writeToFile(redo.peek());
				undo.push(redo.pop());
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	// This method gets json string from currentFile and map it
	private Map<Integer, Task> jsonToMap() throws IOException {
		String json = getFileString(currentFile);
		Map<Integer, Task> jsonMap = gson.fromJson(json, type);
		return jsonMap;
	}



	private void writeToFile(String json) throws IOException{
		FileWriter writer = new FileWriter(currentFile);
		writer.write(json);
		writer.close();	
	}



	// This method reads strings from a file
	public static String getFileString(String fileName) throws IOException{

		byte[] encoded = Files.readAllBytes(Paths.get(fileName));
		return new String(encoded);
	}


}
