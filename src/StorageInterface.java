import java.util.Date;

public interface StorageInterface {
	public String add(String description, Date startDate, Date endDate);
	public String update(int indexOfTaskToUpdate, String descirption,
			Date startDate, Date endDate);
	public String delete(int indexOfTaskToDelete);
}
