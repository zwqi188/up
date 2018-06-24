package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.entity.MyShare;

/**
 * Servlet implementation class SwitchImgServlet
 */
@WebServlet("/SwitchImgServlet.do")
public class SwitchImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwitchImgServlet() {
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
		if(request.getParameter("start")!=null&&request.getParameter("end")!=null){
			start=Integer.parseInt(request.getParameter("start"));
			end=Integer.parseInt(request.getParameter("end"));
		}
		List<MyShare> myShares=shareDao.getMySharesByDate(start,end);
		JSONArray array=JSONArray.fromObject(myShares);
		response.getWriter().print(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
