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

import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.entity.Signspot;

/**
 * Servlet implementation class GetSignspots
 */
@WebServlet("/GetSignspots.do")
public class GetSignspots extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignSpotDao signSpotDao =new SignSpotDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSignspots() {
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
		String cityName=request.getParameter("spotname");
		List<Signspot> signspots=signSpotDao.getSignspotByCityName(cityName);
		JSONArray objArray =JSONArray.fromObject(signspots);
		response.getWriter().write(objArray.toString());
	}

}
