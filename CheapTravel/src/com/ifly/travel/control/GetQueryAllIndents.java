package com.ifly.travel.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifly.travel.dao.IndentDao;
import com.ifly.travel.dao.IndentViewDao;
import com.ifly.travel.dao.SignSpotDao;
import com.ifly.travel.dao.UserDao;
import com.ifly.travel.entity.IndentView;
import com.ifly.travel.util.PageUtil;


/**
 * Servlet implementation class GetUsers
 */
@WebServlet("/GetQueryAllIndents.do")
public class GetQueryAllIndents extends HttpServlet {
	private String passangerName;
	private static final long serialVersionUID = 1L;
	private IndentViewDao viewDao = new IndentViewDao();
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQueryAllIndents() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		if (request.getParameter("passangerName")!=null) {
			passangerName = request.getParameter("passangerName");
		}
		
		String page = request.getParameter("page");
		if (page==null) {
			page = "1";
		}
		request.getSession().setAttribute("queryPassager", passangerName);
		//viewDao.createQueryView(passangerName);
		String userName = request.getSession().getAttribute("username").toString();
		String realName = userDao.getUserByName(userName).getRealName();
		
		List<IndentView> indents = viewDao.getQueryIndentsBypage(realName,Integer.parseInt(page), 5,passangerName);
		int count = viewDao.getQueryAllIndents(passangerName);
		PageUtil pager = new PageUtil(count, Integer.parseInt(page), 5, "GetQueryAllIndents.do");
		request.setAttribute("indents", indents);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("allIndent.jsp").forward(request, response);
	}

}
