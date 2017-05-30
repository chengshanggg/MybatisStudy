package com.imooc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.QueryService;
import com.imooc.service.MaintainService;

import bean.Message;

/**
 * 单挑删除控制层
 * @author xiaoz
 *
 */

@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//前台参数
		String id =req.getParameter("id");
		
		
		MaintainService maintainService=new MaintainService();
		maintainService.delectOne(id);
		
		
		req.getRequestDispatcher("/List").forward(req, resp);
		
//		PrintWriter pw=resp.getWriter();
//		pw.print("hello world");
//		pw.close();
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
