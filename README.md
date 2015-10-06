##### Storage Class

Parameter: String currentFile

##### Constructor:

Storage()
- initializes Storage class with default file name "data.json"

Storage(String name)
- initializes Storage class with name



##### Methods:

|Return Type|Method|Description|
| ---------|----------|----------|
|String	|getFileName() | get current file name |
|void|setFile()|Set the file name to write to|
|void	| clear()|clear current file|
|void|	write(Task)|write Task Object to file|
|ArrayList<Task>|read()|return ArrayList of all tasks in file|
|void|delete(int id)|delete task at the specified id|
|void|update(Task newTask, int id)|Replaces task at id with newTask|
|boolean|	undo()|undo previous change. Returns true if successful|
|boolean|	redo()|redo previous undo. Returns true if successful|


##### Task Class

##Parameters:
	private String description;
	private Date startDate;
	private Date endDate;
	private int priority;
	private int type;
