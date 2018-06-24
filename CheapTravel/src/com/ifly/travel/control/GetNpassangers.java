package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.NpassangerDao;
import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.Npassanger;
import com.ifly.travel.util.PageUtil;

/*import model.Account;
import model.Member;
import model.Permission;
import model.Project;
import util.PageUtil;*/
/**
 * Servlet implementation class GetNpassangers
 */
@WebServlet("/GetNpassangers.do")
public class GetNpassangers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NpassangerDao passangerdao=new NpassangerDao();
	private UserDao userDao=new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNpassangers() {
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
		String page=request.getParameter("page");
		String userName=request.getServletContext().getAttribute("username").toString();
		int userId=userDao.getUserId(userName);
		if(page==null)
		{
			page="1";
		}
		
		/*List<Npassanger> passangers=passangerdao.getAllNpassanger();*/

		List<Npassanger> passangers=passangerdao.getNpassangerBypage(userId,Integer.parseInt(page),5);
		request.setAttribute("passangers", passangers);
		int count=passangerdao.getNpassangerCount();
		PageUtil pager=new PageUtil(count,Integer.parseInt(page),5,"GetNpassangers.do");
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("PassangerInfo.jsp").forward(request, response);
	}
}
