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
 * Servlet implementation class RealEdit
 */
@WebServlet("/RealEdit.do")
public class RealEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NpassangerDao passangerDao = new NpassangerDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealEdit() {
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
		String opt = request.getParameter("opt");
		String optId = request.getParameter("optId");
		if ("Passenger".equals(opt)) {
			String passangerid =request.getParameter("passangerid");
			String passangername =request.getParameter("passangername");
			String passangerphone= request.getParameter("passangerphone");
			String papertype = request.getParameter("papertype");
			String papernumber = request.getParameter("papernumber");
			Npassanger passanger=new Npassanger(Integer.parseInt(passangerid),1, passangername, passangerphone, papertype, papernumber);
			passangerDao.updatePassanger(passanger);
			request.getRequestDispatcher("GetNpassangers.do").forward(request, response);
		}
	}

}
