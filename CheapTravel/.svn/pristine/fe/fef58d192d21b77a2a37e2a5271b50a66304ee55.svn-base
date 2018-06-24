package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.IndentViewDao;
import com.ifly.travel.entity.IndentView;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query.do")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndentViewDao viewDao = new IndentViewDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String passangerName = request.getParameter("passangerName");
		List<IndentView> indents = viewDao.queryIndents(passangerName);
		response.sendRedirect("GetAllIndents.do");
	}

}
