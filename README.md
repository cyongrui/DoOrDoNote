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
|void|	write(Task)|write Task Object to file|
|Task[]|read()|return Task array of all tasks in file|
|boolean|	undo()|undo previous change. Returns true if successful|
|boolean|	redo()|redo previous undo. Returns true if successful|
