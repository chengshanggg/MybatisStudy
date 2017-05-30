package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

@SuppressWarnings("serial")
public class InsertServlet extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			
			//前台参数
			String id=req.getParameter("id");
			String command =req.getParameter("command");
			String description =req.getParameter("description"); 
			String content =req.getParameter("content");
			
			MaintainService maintainService=new MaintainService();
			maintainService.insert(id,command, description, content);
			
			
			req.getRequestDispatcher("/List").forward(req, resp);
			
//			PrintWriter pw=resp.getWriter();
//			pw.print("hello world");
//			pw.close();
		}
		

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doGet(req, resp);
		}
}
