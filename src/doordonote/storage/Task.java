package doordonote.storage;

public abstract class Task {

<<<<<<< HEAD

	protected String description;
	

	public Task(String description){
		this.description = description;
=======
public class Task {
	
	
	private String description;
	private Date startDate;
	private Date endDate;
//	private int priority;
	private int type;
	
	
	public Task(String desc){
		this.description = desc;
		this.type=0;
	}
	
	public Task(String desc, Date endDate){
		this.description = desc;
		this.endDate = endDate;
//		this.priority = priority;
		this.type=1;
	}
	
	public Task(String desc, Date startDate, Date endDate){
		this.description = desc;
		this.startDate = startDate;
		this.endDate = endDate;
//		this.priority = priority;
		this.type = 2;
>>>>>>> be9e6f3e751c9f70529b848bb1708150f80be5ca
	}



	public String getDescription(){
		return description;
	}
	
<<<<<<< HEAD
	public abstract int hashCode();
=======
	public Date getTaskStartDate(){
		return startDate;
	}
	
	
	
//	public int getPriority(){
//		return priority;
//	}
>>>>>>> be9e6f3e751c9f70529b848bb1708150f80be5ca
	
	public abstract boolean equals(Object obj);


	public String toString(){
		String str = "\"";
		str += getDescription();
		str += "\"";
		return str;
	}

<<<<<<< HEAD
=======
	public int getTaskType() {
		return type;
	}

	public Date getTaskEndDate() {
		return endDate;
	}
>>>>>>> be9e6f3e751c9f70529b848bb1708150f80be5ca
	
}
