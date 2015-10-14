package doordonote.storage;

import java.util.Date;

public interface FileIO {
	public String add(String description, Date startDate, Date endDate);
	public String update(Task taskToUpdate, String descirption,
			Date startDate, Date endDate);
	public String delete(Task taskToDelete);
}
