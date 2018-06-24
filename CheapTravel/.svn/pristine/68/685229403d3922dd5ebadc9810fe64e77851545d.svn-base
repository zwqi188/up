package com.ifly.travel.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.NpassangerDao;
import com.ifly.travel.entity.Npassanger;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit.do")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NpassangerDao passangerDao = new NpassangerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		String opt = request.getParameter("opt");
		String optId = request.getParameter("optId");
		if ("Passenger".equals(opt)) {
			Npassanger passanger=passangerDao.lookNpassanger(Integer.parseInt(optId));
			request.setAttribute("passanger", passanger);
			request.getRequestDispatcher("editPassanger.jsp").forward(request,response);
		}
	}

}
