package com.ifly.travel.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgLoadServlet
 */
@WebServlet("/ImgLoadServlet.do")
public class ImgLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream os=response.getOutputStream();
		
		String imgpath=request.getParameter("imgpath");
		imgpath=new String(imgpath.getBytes("iso-8859-1"),"utf-8");
		String fileName=imgpath.substring(imgpath.lastIndexOf("/")+1);
		String rootpath=request.getServletContext().getRealPath("/");
		String realpath=rootpath+imgpath;
		File file=new File(realpath);
		InputStream is=new FileInputStream(file);
		
		response.addHeader("Content-Disposition", "attachment;fileName="
				+ new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
		response.addHeader("Content-Length",
				new Long(file.length()).toString());
		

		byte[] buff = new byte[1024];
		int len = 0;
		while ((len = is.read(buff)) >0) {
			os.write(buff, 0, len);
		}

		os.flush();
		os.close();
		is.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
