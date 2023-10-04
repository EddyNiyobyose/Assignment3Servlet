package com.admission;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


@WebServlet("/AdmissionServlet")
public class AdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isMultipart= ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			java.util.List<FileItem> fileItems = upload.parseRequest((RequestContext) request);
			
			for (FileItem item : fileItems){
				
				if(!item.isFormField()) {
					
					String fieldName= item.getFieldName();
					String fileName= item.getName();
					
				}
					}
			//response.sendRedirect("");
			PrintWriter out= response.getWriter();
			out.println("Thanks For submitting your Information!!!");
		}
	}

}
