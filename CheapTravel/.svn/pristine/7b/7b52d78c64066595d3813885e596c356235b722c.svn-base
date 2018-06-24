package com.ifly.travel.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.CollectDao;
import com.ifly.travel.dao.ShareDao;
import com.ifly.travel.dao.UserDao;

/**
 * Servlet implementation class AddCollectionServlet
 */
@WebServlet("/AddCollectionServlet.do")
public class AddCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollectionServlet() {
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
		String imgpath=request.getParameter("imgpath");
		ShareDao shareDao=new ShareDao();
		UserDao userDao=new UserDao();
		CollectDao collectDao=new CollectDao();
		int shareid=shareDao.getShareId(imgpath);
		System.out.println(shareid+"-"+imgpath);
		int userid=userDao.getUserId(request.getSession().getAttribute("username").toString());
		collectDao.addCollect(userid, shareid);
		response.getWriter().print("收藏成功");
	}

}
