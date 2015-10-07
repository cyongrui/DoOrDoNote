package doordonote.storage;

import java.util.Date;

public class Task {
	
	
	private String description;
	private Date startDate;
	private Date endDate;
	private int priority;
	private int type;
	
	
	public Task(String desc){
		this.description = desc;
		this.type=0;
	}
	
	public Task(String desc, Date endDate){
		this.description = desc;
		this.endDate = endDate;
		this.priority = priority;
		this.type=1;
	}
	
	public Task(String desc, Date startDate, Date endDate){
		this.description = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.type = 2;
	}
	
	public String getDesc(){
		return description;
	}
	
	public int getTaskStartDate(){
		return startDate.getDate();
	}
	
	
	
	public int getPriority(){
		return priority;
	}
	
	public String toString(){
		String str = "\"";
		str += getDesc();
		str += "\"";
		return str;
	}
	
}
