package com.ifly.travel.control;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.MyCollectDao;
import com.ifly.travel.entity.MyCollectView;


/**
 * Servlet implementation class GetMyCollects
 */
@WebServlet("/GetMyCollects.do")
public class GetMyCollects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MyCollectDao collectdao=new MyCollectDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyCollects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<MyCollectView> collectsview=collectdao.getAllMyCollectView();
		request.setAttribute("collectsview", collectsview);
		request.getRequestDispatcher("myCollect.jsp").forward(request, response);
	}

}
