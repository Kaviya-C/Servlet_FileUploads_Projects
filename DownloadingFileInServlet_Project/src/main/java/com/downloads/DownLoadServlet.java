package com.downloads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String fileName="p.txt";
		
		String path ="C:\\Users\\kaviy\\OneDrive\\Desktop\\";
		
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment;filename\""+fileName+"\"");
		
		FileInputStream input = new FileInputStream(path+fileName);
		
		int i;
		while((i=input.read())!=-1)
		{
			out.write(i);
		}
		input.close();
		out.close();
		
	}

}
