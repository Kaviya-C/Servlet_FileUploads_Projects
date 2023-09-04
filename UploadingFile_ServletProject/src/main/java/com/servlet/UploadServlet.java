package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String destinationPath = request.getParameter("destination");
		
		Part part = request.getPart("fileupload");
		
		String fileName = part.getSubmittedFileName();
		
		String finalLocation = destinationPath+ File.separator+fileName;
		
		part.write(finalLocation);
		
		out.println("<h2>Your file uploaded successfully to this path </h2><br>"+finalLocation);
		
	}
}
