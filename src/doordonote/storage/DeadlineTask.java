package doordonote.storage;

import java.util.Date;

public class DeadlineTask extends Task {

	private Date endDate;

	
	public DeadlineTask(String description, Date endDate){
		super(description);
		this.endDate = endDate;
	}
	
	public Date getTaskEndDate(){
		return endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DeadlineTask))
			return false;
		DeadlineTask other = (DeadlineTask) obj;
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
		return true;
	}
	
	
}
