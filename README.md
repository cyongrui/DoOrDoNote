##### Storage

Parameter: String currentFile

##### Constructor:

Storage()
- initializes Storage class with default file name "data.json"

Storage(String name)
- initializes Storage class with name



##### Methods:

|Type|Method|Description|
| ---------|----------|----------|
|String	|getFileName() | get current file name |
|void	| clear()|clear current file|
|void|	write(Task)|-write Task Object to file|
|ArrayList<Task>|read()|return Arraylist of all tasks in file|
|void|	revert()|undo previous change|
 
// Need to know Task Object parameters
