

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

	public Date getTaskStartDate(){
		return startDate;
	}


	public Date getTaskEndDate(){
		return endDate;
	}

	public int getTaskType(){
		return type;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + priority;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Task))
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (priority != other.priority)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
