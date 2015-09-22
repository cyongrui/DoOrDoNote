import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * 
 *  @author: Chen Yongrui
 * 
 */


public class Storage {

	private static final String DEFAULT_NAME = "data.json";
	private static final String FILE_TYPE = ".json";
	
	private JSONObject jsonObj;
	private JSONArray jsonArr;

	/************** Data Members **********************/

	private String currentFile;


	/************** Constructors **********************/

	public Storage(){
		currentFile = DEFAULT_NAME;
		init();
	}

	public Storage(String name){
		if(!name.contains(FILE_TYPE)){
			name += FILE_TYPE;
		}
		currentFile = name;
		init();
	}

	/**************** Accessors ***********************/

	public String getFileName() {
		return currentFile;
	}


	/**************** Methods ***********************/

	public void write(TaskStub task){

		jsonArr.add(task.desc);
		jsonObj.put("Task", jsonArr);

		try {
			writeToFile(jsonObj);
		} 

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(TaskStub task, DateStub date){

		jsonArr.add("Description: " + task.desc);
		jsonArr.add("Date:" + date.date + date.time);


		jsonObj.put("Task", jsonArr);

		try{
			writeToFile(jsonObj);
		}

		catch(IOException e){
			e.printStackTrace();
		}


	}

	public void clear(){
		try{
			FileWriter fw = new FileWriter(currentFile);
			fw.close();
		}

		catch(IOException e){
			e.printStackTrace();
		}
	}


	public void read(){
		
		ArrayList<TaskStub> arr = new ArrayList<TaskStub>();
		JSONParser parser = new JSONParser();

		try{
			Object obj = parser.parse(new FileReader(currentFile));
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONArray tasks = (JSONArray) jsonObj.get("Task");
			Iterator<TaskStub> iterator = tasks.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}

		}

		catch (IOException e){
			e.printStackTrace();
		}

		catch (ParseException e){
			e.printStackTrace();
		}

	}


	private void writeToFile(JSONObject obj) throws IOException{
		FileWriter writer = new FileWriter(currentFile);
		writer.write(obj.toJSONString());
		writer.close();	
	}


	private void init(){
		jsonObj  = new JSONObject();
		jsonArr = new JSONArray();
		
		try {
			File file = new File(currentFile);

			if(!file.exists()){
				file.createNewFile();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
