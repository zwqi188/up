package com.ifly.travel.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.Signspot;
import com.ifly.travel.entity.User;



/**
 * Servlet implementation class MyShare
 */
@WebServlet("/MyShare.do")
public class MyShare extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao uDao=new UserDao();
	private SignSpotDao sDao=new SignSpotDao();
	private ShareDao shareDao = new ShareDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyShare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=getServletContext().getAttribute("username").toString();
		User user=uDao.getUser(username);
		List<Signspot> spotsSelect=sDao.getSignspotByUserId(user.getUserId());
		request.setAttribute("spotsSelect", spotsSelect);
		List<com.ifly.travel.entity.MyShare> allMyShares = shareDao.getAllMyShares();
		int pageSize = allMyShares.size()/9;
		if (allMyShares.size()%9>0) {
			pageSize++;
		}
		int lessNum = allMyShares.size()-(pageSize-1)*9;
		int lessRow = lessNum/3;
		if (lessNum%3>0) {
			lessRow++;
		}
		int lastNum = lessNum-(lessRow-1)*3;
		request.setAttribute("allMyShares", allMyShares);
		request.setAttribute("allMySharesSize", allMyShares.size());
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("lessRow", lessRow);
		request.setAttribute("lastNum", lastNum);
		request.getRequestDispatcher("myShare.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String username=getServletContext().getAttribute("username").toString();
		User user=uDao.getUser(username);
		String theme=request.getParameter("theme");
		String content=request.getParameter("content");
		String spotid=request.getParameter("spotname");
		String photo=request.getParameter("imgPath");
		photo = photo.substring(1);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		shareDao.addShare(user.getUserId(),theme,Integer.parseInt(spotid),content,photo,0,format.format(new Date()));*/
	}

}
