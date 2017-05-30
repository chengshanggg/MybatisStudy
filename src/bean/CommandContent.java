package bean;

public class CommandContent {
	private int Id;
	private String content;
	private String commandId;
	public CommandContent() {
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommandId() {
		return commandId;
	}
	public void setCommandId(String commandId) {
		commandId = commandId;
	}
	
}
