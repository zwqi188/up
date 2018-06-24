package com.ifly.travel.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.entity.MyShare;

/**
 * Servlet implementation class Look
 */
@WebServlet("/Look.do")
public class Look extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShareDao shareDao = new ShareDao();
	private SignSpotDao spotDao = new SignSpotDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Look() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		String optId = request.getParameter("optId");
		if ("MyShare".equals(opt)) {
			MyShare myShare = shareDao.getShareById(Integer.parseInt(optId));
			String spotName = spotDao.getSpotName(myShare.getSpotid());
			request.setAttribute("myShare", myShare);
			request.setAttribute("spotName", spotName);
			request.getRequestDispatcher("myShareDetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
