package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.entity.MyShare;
import com.ifly.travel.entity.Signspot;

/**
 * Servlet implementation class GetSignspots
 */
@WebServlet("/GetCitySignspots.do")
public class GetCitySignspots extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignSpotDao signSpotDao =new SignSpotDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCitySignspots() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		/*String cityName=new String(request.getParameter("cityName").getBytes("ISO-8859-1"), "utf-8");
		if (cityName==null) {
			cityName = "黄山市";
		}
		List<Signspot> signspots=signSpotDao.getSignspotByCityName(cityName);
		request.getSession().setAttribute("cityName", cityName);
		request.setAttribute("signPots", signspots);
		request.getRequestDispatcher("homePage.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityName = request.getParameter("cityName");
		if (cityName==null) {
			cityName = "黄山市";
		}else {
			cityName=new String(cityName.getBytes("ISO-8859-1"), "utf-8");
		}
		List<Signspot> signspots=signSpotDao.getSignspotByCityName(cityName);
		request.setAttribute("cityName", cityName);
		request.setAttribute("signPots", signspots);
		
		
		ShareDao shareDao=new ShareDao();
		int start=1;
		int end=3;
		List<MyShare> myShares=shareDao.getMySharesByDate(start,end);
		List<MyShare> mySharesbynum=shareDao.getMySharesByNum(start,end);
		request.getSession().setAttribute("myShares", myShares);
		request.getSession().setAttribute("mySharesbynum", mySharesbynum);
		
		request.getRequestDispatcher("homePage.jsp").forward(request, response);
		/*JSONArray objArray =JSONArray.fromObject(signspots);
		response.getWriter().write(objArray.toString());*/
	}

}
