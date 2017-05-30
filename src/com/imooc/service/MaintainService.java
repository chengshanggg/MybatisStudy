package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

public class MaintainService {
	/**
	 * 单条删除
	 * @param id
	 */
	public void delectOne (String id) {
		if(id!=null&&!"".equals(id.trim())){
			MessageDao messageDao=new MessageDao();
			messageDao.delectOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delectBatch(String[] ids){
		MessageDao messageDao=new MessageDao();
		List<Integer> idlist=new ArrayList<>();
		for(int i=0;i<ids.length;i++){
			idlist.add(Integer.parseInt(ids[i]));
		}
		messageDao.delectBatch(idlist);
		
	}
	
	/**
	 * 插入 service层
	 * @param command
	 * @param description
	 * @param content
	 */
	public void insert(String id,String command,String description,String content) {
		
		MessageDao messageDao=new MessageDao();
		messageDao.insert(Integer.valueOf(id),command, description, content);
	}

	
}
