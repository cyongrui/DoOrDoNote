
public class Task {
	
	private String desc;
	private String time;
	private String date;
	private int priority;
	
	public Task(){
		desc = "task description";
	}
	
	public Task(String desc, String date, String time, int priority){
		this.desc = desc;
		this.date = date;
		this.time = time;
		this.priority = priority;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTime(){
		return time;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public String toString(){
		String str = getDesc();
		str += getDate();
		str += getTime();
		return str;
	}
	
}
