package bean;

import java.util.List;

public class CommandMain {
	private int id;
	private String name;
	private String description;
	private List<CommandContent> commandList;
	public CommandMain() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommandContent> getCommandList() {
		return commandList;
	}
	public void setCommandList(List<CommandContent> commandList) {
		this.commandList = commandList;
	}
	
}
