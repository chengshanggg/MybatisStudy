package com.imooc.service;

import java.util.List;
import java.util.Random;

import com.imooc.dao.CommandDao;
import com.imooc.dao.MessageDao;

import bean.CommandContent;
import bean.CommandMain;
import bean.Message;
import util.Iconst;

public class QueryService {
	public List<Message> queryCommand (String command,String description) {
		MessageDao messageDao=new MessageDao();
		return messageDao.queryCommand(command, description);
	}
	
	public String queryByCommand(String command){
		CommandDao messageDao = new CommandDao();
		List<CommandMain> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			messageList = messageDao.queryCommand(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getName() + "]可以查看" + messageList.get(i).getDescription());
			}
		//	System.out.println(result.toString());
			return result.toString();
		}
		messageList = messageDao.queryCommand(command, null);
		if(messageList.size() > 0) {
			List<CommandContent> commandList=messageList.get(0).getCommandList();
			int index=new Random().nextInt(commandList.size());
			return commandList.get(index).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	
}
