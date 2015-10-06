import java.util.Date;

public class Task {
	
	
	private String desc;
	private Date startDate;
	private Date endDate;
	private int priority;
	private int type;
	
	public Task(){
		desc = "task description";
	}
	
	public Task(String desc, int priority){
		this.desc = desc;
		this.type=0;
	}
	
	public Task(String desc, Date endDate, int priority){
		this.desc = desc;
		this.endDate = endDate;
		this.priority = priority;
		this.type=1;
	}
	
	public Task(String desc, Date startDate, Date endDate, int priority){
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.type = 2;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public int getTaskStartDate(){
		return startDate.getDate();
	}
	
	
	
	public int getPriority(){
		return priority;
	}
	
	public String toString(){
		String str = "Description: ";
		str += getDesc();
		str += ". ";
		return str;
	}
	
}
