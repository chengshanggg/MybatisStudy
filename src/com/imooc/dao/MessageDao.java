package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.PreparedStatement;

import bean.Message;
import db.DBAccess;

public class MessageDao {
	

	/**
	 * 根据条件查询command表
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Message> queryCommand (String command,String description) {
		DBAccess daAccess =new DBAccess();
		SqlSession sqlSession =null;
		List<Message> messageList=new ArrayList<Message>();
		try {
			sqlSession=daAccess.getSqlSession();
			//执行sql语句
			Message message=new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList=sqlSession.selectList("Message.queryCommand",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 根据ID 删除 对应记录
	 * @param id
	 * @return
	 */
	public void delectOne (int id) {
		DBAccess daAccess =new DBAccess();
		SqlSession sqlSession =null;
		try {
			sqlSession=daAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delectBatch(List<Integer> ids){
		DBAccess daAccess =new DBAccess();
		SqlSession sqlSession =null;
		try {
			sqlSession=daAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 插入数据
	 * @param command
	 * @param description
	 * @param content
	 */
	public void insert (int id,String command,String description,String content) {
		DBAccess daAccess =new DBAccess();
		SqlSession sqlSession =null;
		try {
			Message message=new Message();
			message.setId(id);
			message.setCommand(command);
			message.setDescription(description);
			message.setContent(content);
			sqlSession=daAccess.getSqlSession();
			//执行sql语句
			sqlSession.insert("Message.insert",message);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}

	
	
//	  public static void main(String[] args) {
//		MessageDao dao=new MessageDao();
//		dao.queryCommand("", "");
//	}
	
	/*public List<Message> queryCommand (String command,String description) {
		
		List<Message> messageList=new ArrayList<Message>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root");
			StringBuilder sql=new StringBuilder("select * from command where 1=1 ");
			
			//设置List缓存
			List<String> paramList=new ArrayList<>();
			if(command!=null&&!"".equals(command.trim())){
				sql.append("and COMMAND=? ");
				paramList.add(command);
			}
			if(description!=null&&!"".equals(description.trim())){
				sql.append("and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}
			System.out.println(paramList.size());
			PreparedStatement statement=(PreparedStatement) conn.prepareStatement(sql.toString());
			for(int i=0;i<paramList.size();i++){
				statement.setString(i+1, paramList.get(i));
			}
			System.out.println(sql.toString());
			ResultSet rs=statement.executeQuery();
			
			
			while(rs.next()){
				Message message=new Message();
				message.setId(rs.getInt("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescrion(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
				messageList.add(message);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}*/

	
}
