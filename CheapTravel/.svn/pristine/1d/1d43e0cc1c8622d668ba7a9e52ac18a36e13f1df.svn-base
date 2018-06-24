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
 * Servlet implementation class GetImgServlet
 */
@WebServlet("/GetImgServlet.do")
public class GetImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String imgname=request.getParameter("imgname");
		String imgpath=request.getParameter("imgpath");
		String rootpath=request.getServletContext().getRealPath("/");
		File file=new File(rootpath+imgpath);
		InputStream is=new FileInputStream(file);
		OutputStream os=response.getOutputStream();
		int len=0;
		byte[] buff=new byte[1024];
		while((len=is.read(buff))>0){
			os.write(buff, 0, len);
		}
		is.close();
		os.flush();
		os.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
