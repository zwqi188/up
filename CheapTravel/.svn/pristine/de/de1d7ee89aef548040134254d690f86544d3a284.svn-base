package com.ifly.travel.control;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.IndentDao;
import com.ifly.travel.dao.IndentViewDao;
import com.ifly.travel.dao.TicketDao;
import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.IndentView;

/**
 * Servlet implementation class AddTravelServlet
 */
@WebServlet("/JumpPay.do")
public class JumpPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JumpPay() {
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
		String spotname=request.getParameter("spotname");
		int allPrice=Integer.parseInt(request.getParameter("allPrice"));
		int price=Integer.parseInt(request.getParameter("hprice"));
		String dateStr=request.getParameter("date");
		Date buyDate = new Date(dateStr);
		int number=Integer.parseInt(request.getParameter("number"));
		String passengerName=request.getParameter("passengerName");
		String userName = request.getSession().getAttribute("username").toString();
		String telphone = userDao.getUserByName(userName).getTelphone();
		IndentView indent = new IndentView(userName, telphone, spotname, passengerName, price, allPrice, buyDate, number);
		request.getSession().setAttribute("indent", indent);
		
		request.getRequestDispatcher("pay.jsp").forward(request, response);
		
	}

}
