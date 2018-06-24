package com.ifly.travel.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.IndentDao;
import com.ifly.travel.dao.IndentViewDao;
import com.ifly.travel.dao.NpassangerDao;
import com.ifly.travel.dao.PassangerDao;
import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.dao.TicketDao;
import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.IndentView;
import com.ifly.travel.entity.Npassanger;
import com.ifly.travel.entity.User;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add.do")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NpassangerDao passangerDao = new NpassangerDao(); 
	private TicketDao ticketDao = new TicketDao();
	private IndentDao indentDao = new IndentDao();
	private SignSpotDao spotDao = new SignSpotDao();
	private UserDao userDao = new UserDao();
	private ShareDao shareDao = new ShareDao();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		if ("Passenger".equals(opt)) {
			String userName = request.getSession().getAttribute("username").toString();
			int userId = userDao.getUserId(userName);
			String passangername =request.getParameter("passangername");
			String passangerphone= request.getParameter("passangerphone");
			String papertype = request.getParameter("papertype");
			String papernumber = request.getParameter("papernumber");
			Npassanger passanger=new Npassanger(userId,passangername, passangerphone, papertype, papernumber);
			passangerDao.addNpassanger(passanger);
			
			
			List<String> passangers=passangerDao.getPassanger(userName);
			request.getSession().setAttribute("passangers", passangers);
			
			request.getRequestDispatcher("GetNpassangers.do").forward(request, response);
		}
		if ("ImgShare".equals(opt)) {
			String imgpath=request.getParameter("imgpath");
			String likecount=request.getParameter("likecount");
			ShareDao shareDao=new ShareDao();
			shareDao.updateShare(imgpath, Integer.parseInt(likecount));
			response.getWriter().print(Integer.parseInt(likecount)+1);
		}
		if ("Pay".equals(opt)) {
			 IndentView indent =  (IndentView) request.getSession().getAttribute("indent");
			 int spotId = spotDao.getSignspotId(indent.getSpotName());
			 SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			 String dataString = format.format(indent.getBuyDate());
			 ticketDao.addTicket(spotId,indent.getPrice(),dataString,indent.getNum(),indent.getPassangerName());
			 indentDao.addIndent(indent.getSpotName(), userDao.getUserId(indent.getRealName()));
			 request.getRequestDispatcher("buyInfo.jsp").forward(request, response);
		}
		if ("MyShare".equals(opt)) {
			String username=getServletContext().getAttribute("username").toString();
			User user=userDao.getUser(username);
			String theme=request.getParameter("theme");
			String content=request.getParameter("content");
			String spotid=request.getParameter("spotname");
			//String photo=request.getServletContext().getRealPath("/").replace("\\", "/")+request.getParameter("imgPath");
			String photo=request.getParameter("imgPath");
			photo = photo.substring(1);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		    
			shareDao.addShare(user.getUserId(),theme,Integer.parseInt(spotid),content,photo,0,format.format(new Date()));
		}
	}

}
