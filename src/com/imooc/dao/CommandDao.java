package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.CommandMain;
import bean.Message;
import db.DBAccess;

public class CommandDao {
	public List<CommandMain> queryCommand (String name,String description) {
		DBAccess daAccess =new DBAccess();
		SqlSession sqlSession =null;
		List<CommandMain> commandMainList=new ArrayList<CommandMain>();
		try {
			sqlSession=daAccess.getSqlSession();
			//执行sql语句
			CommandMain commandMain=new CommandMain();
			commandMain.setName(name);
			commandMain.setDescription(description);
			commandMainList=sqlSession.selectList("CommandMain.queryCommandMain",commandMain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return commandMainList;
	}
}
