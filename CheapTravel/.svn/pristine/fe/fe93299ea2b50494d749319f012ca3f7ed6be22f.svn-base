package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.entity.MyShare;

/**
 * Servlet implementation class GetShareImgsServlet
 */
@WebServlet("/GetShareImgsServlet.do")
public class GetShareImgsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShareImgsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShareDao shareDao=new ShareDao();
		int start=1;
		int end=3;
		List<MyShare> myShares=shareDao.getMySharesByDate(start,end);
		List<MyShare> mySharesbynum=shareDao.getMySharesByNum(start,end);
		request.getSession().setAttribute("myShares", myShares);
		request.getSession().setAttribute("mySharesbynum", mySharesbynum);
		request.getRequestDispatcher("imgShare.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
