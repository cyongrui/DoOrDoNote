package doordonote.storage;

public abstract class Task {


	protected String description;
	

	public Task(String description){
		this.description = description;
	}



	public String getDescription(){
		return description;
	}
	
	public abstract int hashCode();
	
	public abstract boolean equals(Object obj);


	public String toString(){
		String str = "\"";
		str += getDescription();
		str += "\"";
		return str;
	}

	
}
