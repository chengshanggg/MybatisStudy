package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;

import bean.Message;



/**
 * ��ʾ�����б�
 * @author xiaoz
 *
 */
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//前台参数
		String command =req.getParameter("command");
		String description =req.getParameter("description");
	//	System.out.println("====="+command+"====="+description);
		
		
		//传向前台
		req.setAttribute("command", command);
		req.setAttribute("description",description );
		
		List<Message> messageList=new ArrayList<Message>();
		
		QueryService listService =new QueryService();
		req.setAttribute("messageList", listService.queryCommand (command,description));
		
		
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
		
//		PrintWriter pw=resp.getWriter();
//		pw.print("hello world");
//		pw.close();
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
